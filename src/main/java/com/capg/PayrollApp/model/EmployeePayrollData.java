package com.capg.PayrollApp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.PayrollApp.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData implements Serializable{
	
	  
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long id;
        private String name;
        private String gender;
        private String department;
        private double basic_pay;
        private String start;
        
        public EmployeePayrollData() {}
        
        public EmployeePayrollData(String name, String gender, String department, double salary, String startDate) {
        	this.name = name;
        	this.gender = gender;
        	this.department = department;
        	this.basic_pay = salary;
        	this.start = startDate;
        }

}
