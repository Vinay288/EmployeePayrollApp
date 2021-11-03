package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	public String name;
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

}
