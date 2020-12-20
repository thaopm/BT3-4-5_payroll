package com.pmt.payroll.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmt.payroll.model.Employee;
import com.pmt.payroll.service.EmployeeService;

@Controller
//@RequestMapping("/employee")
public class PayrollController {

	private EmployeeService employeeService = new EmployeeService();

	@GetMapping("/")
	public String showEmployees(Model model) {
		List<Employee> employees = null;
		String message = "";
		String view = "";
		try {
			employees = employeeService.getEmployeesFromCSV();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			model.addAttribute("employees", employees);
			model.addAttribute("dateFormatter", dateFormatter);
			return "employees";
		} catch (FileNotFoundException e) {
			message = "CSV File Not Found";
			model.addAttribute("message", message);
			return "error";
		} catch (IOException e) {
			message = "IO Exception Occured";
			model.addAttribute("message", message);
			return "error";
		}
	}

}
