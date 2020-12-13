package com.capg.PayrollApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.PayrollApp.model.EmployeePayrollData;

public interface EmployeePayrollAppRepository extends JpaRepository<EmployeePayrollData, Long> {

}
