package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeFamilyDeatilsDto;
import com.employee.dto.MessageDto;

public interface IEmployeeFamilyDeatilsService {

	ResponseEntity<MessageDto> addEmployeeIdentityProof(List<EmployeeFamilyDeatilsDto> employeeFamilyDeatilsDtos);

	ResponseEntity<MessageDto> updateEmployeeIdentityProof(EmployeeFamilyDeatilsDto employeeFamilyDeatilsDto);

	ResponseEntity<EmployeeFamilyDeatilsDto> getEmployeeIdentityProof(Integer employeeFamilyDeatilsId);

	ResponseEntity<List<EmployeeFamilyDeatilsDto>> getAllEmployeeIdentityProof();

	ResponseEntity<MessageDto> deleteEmployee(Integer employeeFamilyDeatilsId);

}
