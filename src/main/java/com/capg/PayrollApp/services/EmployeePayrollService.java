package com.capg.PayrollApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.PayrollApp.dto.User;
import com.capg.PayrollApp.exception.EmpPayrollException;
import com.capg.PayrollApp.model.EmployeePayrollData;
import com.capg.PayrollApp.repository.EmployeePayrollAppRepository;


@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollAppRepository empPayrollRepository;

	@Override
	public User CreateUser(User user) throws EmpPayrollException {
		if (Objects.nonNull(user.getName()) && Objects.nonNull(user.getSalary())) {
			EmployeePayrollData empPayroll = new EmployeePayrollData(user.getName(),
					user.getGender(), user.getDepartment(), user.getSalary(), user.getStartDate());
			return new User(empPayrollRepository.save(empPayroll));
		} else {
			throw new EmpPayrollException("Invalid Entry");
		}
	}

	@Override
	public User UpdateUser(User user) throws EmpPayrollException {

		return empPayrollRepository.findById(user.getId()).map(employee -> {
			if (Objects.nonNull(user.getName())) {
				employee.setName(user.getName());
			}
			if (Objects.nonNull(user.getSalary())) {
				employee.setBasic_pay(user.getSalary());
			}
			return new User(empPayrollRepository.save(employee));
		}).orElseThrow(() -> new EmpPayrollException("Employee match not found"));
	}

	@Override
	public User deleteUser(Long id) throws EmpPayrollException {
		return empPayrollRepository.findById(id).map(employee -> {
			empPayrollRepository.deleteById(employee.getId());
			return new User(employee);
		}).orElseThrow(() -> new EmpPayrollException("Employee match not found"));
	}

	@Override
	public List<User> getAllUser() {
		return empPayrollRepository.findAll().stream().map(employee -> new User(employee)).collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) throws EmpPayrollException {
		EmployeePayrollData emp = empPayrollRepository.findById(id).orElse(null);
		if (Objects.nonNull(emp)) {
			return new User(emp);
		} else {
			throw new EmpPayrollException("Employee match not found");
		}
	}
	}
