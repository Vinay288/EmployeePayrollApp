package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
public class EmployeePayrollController {
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Vinay", 1000000));
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable int employeeId) {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Vinay", 1000000));
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int employeeId) {
		ResponseDTO response = new ResponseDTO("deleted", "deleted id:" + employeeId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
}
