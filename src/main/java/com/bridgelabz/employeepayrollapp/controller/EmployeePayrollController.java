package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> employeeDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO response = new ResponseDTO("success", employeeDataList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable int employeeId) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(employeeId);
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{employeeId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int employeeId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(employeeId,
				employeePayrollDTO);
		ResponseDTO response = new ResponseDTO("Success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int employeeId) {
		employeePayrollService.deleteEmployeePayrollData(employeeId);
		ResponseDTO response = new ResponseDTO("deleted", "deleted id:" + employeeId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
}
