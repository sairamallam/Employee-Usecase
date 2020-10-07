package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeIdentityProofDto;
import com.employee.dto.MessageDto;

public interface IEmployeeIdentityProofService {

	ResponseEntity<MessageDto> addEmployeeIdentityProof(List<EmployeeIdentityProofDto> employeeIdentityProofDtos);

	ResponseEntity<MessageDto> updateEmployeeIdentityProof(EmployeeIdentityProofDto employeeIdentityProofDto);

	ResponseEntity<EmployeeIdentityProofDto> getEmployeeIdentityProof(Integer employeeIdentityProofId);

	ResponseEntity<List<EmployeeIdentityProofDto>> getAllEmployeeIdentityProof();

	ResponseEntity<MessageDto> deleteEmployee(Integer employeeIdentityProofId);

}
