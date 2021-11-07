package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is Invalid!")
	public String name;

	@NotNull
	@Min(value = 500, message = "Minimum wage should be more then 500")
	public long salary;

	public String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	public List<String> departments;
}
