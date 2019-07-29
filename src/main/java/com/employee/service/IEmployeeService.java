package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.model.EmployeeDetails;

public interface IEmployeeService {
	
	public ResponseEntity<String> registration(EmployeeDetails employeeDetails);
	public ResponseEntity<String> update(EmployeeDetails employeeDetails);
	public ResponseEntity<EmployeeDetails> getEmployee(Long employeeId);
	public ResponseEntity<List<EmployeeDetails>> getAllEmployee();
	public ResponseEntity<String> deleteEmployee(Long employeeId);


}
