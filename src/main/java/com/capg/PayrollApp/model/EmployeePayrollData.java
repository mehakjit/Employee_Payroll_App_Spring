package com.capg.PayrollApp.model;

import com.capg.PayrollApp.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
public class EmployeePayrollData {
	int empId;
	String name;
	long salary;
	
	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.empId=empId;
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
	}

}
