package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.Employee;

@RestController
public class EmployeePayrollController {
	@RequestMapping(value = { "", "/", "/home" })
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}

	@RequestMapping(value = { "/query" })
	public String sayHi(@RequestParam(value = "fname", defaultValue = "vinay") String fname,
			@RequestParam(value = "lname", defaultValue = "Hiremath") String lname) {
		return "welcome to the world of " + fname + " " + lname;
	}

	@GetMapping("/param/{name}")
	public String parameterName(@PathVariable String name) {
		return "Hi " + name;
	}

	@GetMapping("/post")
	public String setUser(@RequestBody Employee employee) {
		return "Hello " + employee.getFirstName() + " " + employee.getLastName();
	}

	@PutMapping("/put/{firstName}")
	public String sayHelloPutMethod(@PathVariable String firstName,
			@RequestParam(value = "lastName", defaultValue = "Hiremath") String lastName) {
		return "Hello " + firstName + " " + lastName;
	}
}
