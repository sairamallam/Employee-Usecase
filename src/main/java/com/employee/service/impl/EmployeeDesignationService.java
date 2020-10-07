package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeDesignationDto;
import com.employee.dto.MessageDto;
import com.employee.model.identies.EmployeeDesignation;
import com.employee.model.identies.repository.EmployeeDesignationRepository;
import com.employee.service.IEmployeeDesignationService;

public class EmployeeDesignationService implements IEmployeeDesignationService {

	@Autowired
	EmployeeDesignationRepository  employeeDesignationRepository;
	@Override
	public ResponseEntity<MessageDto> addEmployeeDesignation(EmployeeDesignationDto employeeDesignationDto) {
		
		EmployeeDesignation  employeeDesignation=new  EmployeeDesignation();
		BeanUtils.copyProperties(employeeDesignationDto, employeeDesignation);

		employeeDesignationRepository.save(employeeDesignation);
		
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(" employee deleted sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

	@Override
	public ResponseEntity<MessageDto> removeEmployeeDesignation(Integer employeeDesignationId) {
		employeeDesignationRepository.deleteById(employeeDesignationId);
		return null;
	}

	@Override
	public ResponseEntity<List<EmployeeDesignationDto>> getAllEmployeeDesignations() {
		// TODO Auto-generated method stub
		return null;
	}

}
