package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeDetailsDto;
import com.employee.model.EmployeeDetails;

public interface IEmployeeService {
	
	 ResponseEntity<String> registration(List<EmployeeDetailsDto> employeeDetailsDtos);
	 ResponseEntity<String> update(EmployeeDetailsDto employeeDetailsDto);
	 ResponseEntity<EmployeeDetails> getEmployee(Long employeeId);
	 ResponseEntity<List<EmployeeDetailsDto>> getAllEmployee();
	 ResponseEntity<String> deleteEmployee(Long employeeId);


}
