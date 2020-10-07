package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeTypeDto;
import com.employee.dto.MessageDto;

public interface IEmployeeTypeService {
	ResponseEntity<MessageDto>  addEmployeeType(EmployeeTypeDto employeeTypeDto);
	ResponseEntity<MessageDto> deleteEmployeeType(Integer employeeTypeId);
	ResponseEntity<List<EmployeeTypeDto>> getAllEmployeeType();

}
