package com.pmt.payroll.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.pmt.payroll.model.Employee;
import com.pmt.payroll.util.DateUtil;

@Service
public class EmployeeService {

	public List<Employee> getEmployeesFromCSV() throws FileNotFoundException, IOException {
		List<Employee> employees = new ArrayList<Employee>();

		File file = ResourceUtils.getFile("classpath:data/employee.csv");

		CsvMapper mapper = new CsvMapper(); // Dùng để ánh xạ cột trong CSV với từng trường trong POJO
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); // Dòng đầu tiên sử dụng làm Header
		// setter required
		ObjectReader oReader = mapper.readerFor(Employee.class).with(schema); // Cấu hình bộ đọc CSV phù hợp với
																				// kiểu Car.class
		Reader fileReader = new FileReader(file);
		MappingIterator<Employee> iterator = oReader.readValues(fileReader); // Iterator đọc từng dòng trong file
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			employee.setAge(calculateAge(employee.getDob()));
			employee.setWorkingTime(calculateWorkingTime(employee.getStartdate()));
			employee.setCurrentSalary(calculateCurrentSalary(employee.getStartdate(), employee.getSalary()));
			employees.add(employee);
		}
		return employees;
	}

	public int calculateAge(String dob) {
		LocalDate birthDay = LocalDate.parse(dob, DateUtil.DATEFORMATTER);
		return (int) (birthDay.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f);
	}

	public String calculateWorkingTime(String startdate) {
		LocalDate startDate = LocalDate.parse(startdate, DateUtil.DATEFORMATTER);
		Period diff = Period.between(startDate, java.time.LocalDate.now());
		return diff.getYears() + " năm, " + diff.getMonths() + " tháng";
	}

	public int calculateCurrentSalary(String startdate, int salary) {
		LocalDate startDate = LocalDate.parse(startdate, DateUtil.DATEFORMATTER);
		Period diff = Period.between(startDate, java.time.LocalDate.now());
		int workingYears = diff.getYears();
		int curSalary = salary;
		for (int i = 1; i <= workingYears; i++) {
			curSalary += curSalary * 0.06;
		}
		return curSalary;
	}
}
