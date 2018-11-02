package com.cg.project.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	private int employeeId;
	private String firstName,lastName;
	private int basicSalary;
	
	@Autowired
	private Address address;
	public Employee() {}
	
	public Employee(int employeeId, String firstName, String lastName, int basicSalary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basicSalary = basicSalary;
		System.out.println("int employeeId, String firstName, String lastName, int basicSalary");
	}

	public Employee(int employeeId, String firstName, String lastName, int basicSalary, Address address) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basicSalary = basicSalary;
		this.address = address;
		System.out.println("int employeeId, String firstName, String lastName, int basicSalary, Address address");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", basicSalary=" + basicSalary + ", address=" + address + "]";
	}
	
}
