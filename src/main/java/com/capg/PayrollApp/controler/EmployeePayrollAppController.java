package com.capg.PayrollApp.controler;

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
import org.springframework.web.bind.annotation.RestController;

import com.capg.PayrollApp.dto.EmployeePayrollDTO;
import com.capg.PayrollApp.dto.ResponseDTO;
import com.capg.PayrollApp.model.EmployeePayrollData;
import com.capg.PayrollApp.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollAppController {

		@Autowired
		private IEmployeePayrollService employeePayrollService;

		@RequestMapping(value = { "", "/", "/get" })
		public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
			List<EmployeePayrollData> empDataList = null;
			empDataList = employeePayrollService.getEmployeePayrollData();
			ResponseDTO respDTO = new ResponseDTO("Get call for Success ", empDataList);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}

		@GetMapping("/get/{empId}")
		public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
			EmployeePayrollData empData =null;
			empData =employeePayrollService.getEmployeePayrollDataById(empId);
			ResponseDTO respDTO = new ResponseDTO("Get Call success for ID  ", empData);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}

		@PostMapping("/create")
		public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
			EmployeePayrollData empData=null;
			empData =employeePayrollService.createEmployeePayrollData(empPayrollDTO);
			ResponseDTO respDTO = new ResponseDTO("Created EmployeePayroll Data Success", empData);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}

		@PutMapping("/update/{empId}")
		public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
				@RequestBody EmployeePayrollDTO employeePayrollDTO) {
			EmployeePayrollData employeeData = null;
			employeeData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
			ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", employeeData);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}

		@DeleteMapping("/delete/{empId}")
		public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
			employeePayrollService.deleteEmployeePayrollData(empId);
			ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id " + empId);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
}
