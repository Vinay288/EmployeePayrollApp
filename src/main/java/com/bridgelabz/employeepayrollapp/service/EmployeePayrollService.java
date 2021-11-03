package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollList.size() + 1,
				employeePayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.setName(employeePayrollDTO.name);
		employeePayrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(employeeId - 1, employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {
		employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
		employeePayrollList.remove(employeeId - 1);

	}

}
