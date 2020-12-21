package com.pmt.payroll.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.pmt.payroll.model.Employee;

@Repository
public class EmployeeRepository {

	/**
	 * Read Employee Info List From CSV File
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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
			employees.add(employee);
		}
		return employees;
	}

}
