package com.capg.PayrollApp.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.PayrollApp.model.EmployeePayrollData;

import lombok.Data;

@Data
public class User {
		    private Long id;
		    private String name;
	        private String gender;
	        private String department;
	        private double salary;
	        private String startDate;
	        
		    public User(){

		    }

		    public User(EmployeePayrollData employee){
		        this.id = employee.getId();
		        this.name = employee.getName();
		        this.gender = employee.getGender();
		        this.department = employee.getDepartment();
		        this.salary = employee.getBasic_pay();
		        this.startDate = employee.getStart();
		    }
		    
		    public void setName(String name) {
		    	Pattern pattern = Pattern.compile("^[A-Z]{1}[a-zA-Z\\s]{2,}$");
				Matcher matcher = pattern.matcher(name);
				Boolean b = matcher.find();
				if(b) this.name = name;
				else this.name = null;
		    }
}
