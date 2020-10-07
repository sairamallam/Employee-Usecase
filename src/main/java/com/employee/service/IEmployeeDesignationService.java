package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeDesignationDto;
import com.employee.dto.MessageDto;

public interface IEmployeeDesignationService {
	
	ResponseEntity<MessageDto> addEmployeeDesignation(EmployeeDesignationDto employeeDesignationDto);
	ResponseEntity<MessageDto> removeEmployeeDesignation(Integer employeeDesignationId);
	ResponseEntity<List<EmployeeDesignationDto>> getAllEmployeeDesignations();

}
