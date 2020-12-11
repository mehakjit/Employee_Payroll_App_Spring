package com.capg.PayrollApp.dto;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
public String name;
public long salary;

public EmployeePayrollDTO(String name, long salary) {
this.name=name;
this.salary=salary;
}
}
