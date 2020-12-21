package com.pmt.payroll.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pmt.payroll.model.Employee;
import com.pmt.payroll.repository.EmployeeRepository;
import com.pmt.payroll.util.DateUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Get employee list and process Employee Info
	 * 
	 * @return 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Employee> getEmployees() throws FileNotFoundException, IOException {
		List<Employee> employees = employeeRepository.getEmployeesFromCSV();

		employees.forEach(employee -> {
			employee.setAge(calculateAge(employee.getDob()));
			employee.setWorkingTime(calculateWorkingTime(employee.getStartdate()));
			employee.setCurrentSalary(calculateCurrentSalary(employee.getStartdate(), employee.getSalary()));
		});

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
