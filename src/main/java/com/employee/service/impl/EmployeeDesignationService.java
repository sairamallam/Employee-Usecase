package com.employee.service.impl;

import java.util.ArrayList;
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
		messageDto.setMessage("EmployeeDesignation added sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

	@Override
	public ResponseEntity<MessageDto> removeEmployeeDesignation(Integer employeeDesignationId) {
		employeeDesignationRepository.deleteById(employeeDesignationId);

		MessageDto messageDto = new MessageDto();
		messageDto.setMessage("EmployeeDesignation deleted sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

	@Override
	public ResponseEntity<List<EmployeeDesignationDto>> getAllEmployeeDesignations() {
		List<EmployeeDesignation> employeeDesignationList = employeeDesignationRepository.findAll();
		List<EmployeeDesignationDto> employeeDesignationDtoList=new ArrayList<>();
		employeeDesignationList.forEach(employeeDesignation->{
			EmployeeDesignationDto employeeDesignationDto=new EmployeeDesignationDto();
			BeanUtils.copyProperties(employeeDesignation, employeeDesignationDto);
			employeeDesignationDtoList.add(employeeDesignationDto);
		});
		
		return ResponseEntity.ok().body(employeeDesignationDtoList);
	}

}
