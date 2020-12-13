package com.capg.PayrollApp.services;

import java.util.List;

import com.capg.PayrollApp.dto.User;
import com.capg.PayrollApp.exception.EmpPayrollException;

public interface IEmployeePayrollService {
	User CreateUser(User user) throws EmpPayrollException;

	User UpdateUser(User user) throws EmpPayrollException;

	User deleteUser(Long id) throws EmpPayrollException;

	List<User> getAllUser();
	
	User getUserById(Long id) throws EmpPayrollException;

}
