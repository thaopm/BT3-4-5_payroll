package com.pmt.payroll.model;

import com.pmt.payroll.util.DateUtil;

public class Employee {

	private String name;
	private String dob;
	private String role;
	private String startdate;
	private int salary;
	private int age;

	public Employee() {
		super();
	}

	public Employee(String name, String dob, String role, String startdate, int salary) {
		this.name = name;
		this.dob = dob;
		this.role = role;
		this.startdate = startdate;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) throws Exception {
		this.dob = DateUtil.formatDate(dob);
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setStartdate(String startdate) throws Exception {
		this.startdate = DateUtil.formatDate(startdate);
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getRole() {
		return role;
	}

	public String getStartdate() {
		return startdate;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dob=" + dob + ", role=" + role + ", startdate=" + startdate + ", salary="
				+ salary + "]";
	}

}
