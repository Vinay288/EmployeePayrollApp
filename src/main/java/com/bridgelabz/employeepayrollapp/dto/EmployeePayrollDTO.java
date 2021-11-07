package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is Invalid!")
	public String name;

	@NotNull
	@Min(value = 500, message = "Minimum wage should be more then 500")
	public long salary;

	@NotNull
	@Pattern(regexp = "male|female", message = "gender should be male or female")
	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start Date should not be Null")
	@PastOrPresent(message = "start date should be past or todays date")
	public LocalDate startDate;

	@NotNull(message = "note should not be Null")
	public String note;

	@NotNull(message = "profile pic should not be Null")
	public String profilePic;

	@NotNull(message = "department list should not be Null")
	public List<String> departments;
}
