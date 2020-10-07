package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeTypeDto;
import com.employee.dto.MessageDto;
import com.employee.exception.EmployeeException;
import com.employee.model.identies.EmployeeType;
import com.employee.model.identies.repository.EmployeeTypeRepository;
import com.employee.service.IEmployeeTypeService;

@Service
public class EmployeeTypeService implements IEmployeeTypeService {
	@Autowired
	EmployeeTypeRepository employeeTypeRepository;

	@Override
	public ResponseEntity<MessageDto> addEmployeeType(EmployeeTypeDto employeeTypeDto) {

		EmployeeType employeeType = new EmployeeType();
		employeeType.setEmployeeTypeDtoValue(employeeTypeDto.getEmployeeTypeDtoValue());
		employeeTypeRepository.save(employeeType);
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(employeeTypeDto.getEmployeeTypeDtoValue() + " successfully saaved");

		return ResponseEntity.status(HttpStatus.OK).body(messageDto);
	}

	@Override
	public ResponseEntity<MessageDto> deleteEmployeeType(Integer employeeTypeId) {
		employeeTypeRepository.deleteById(employeeTypeId);
		if(employeeTypeRepository.findById(employeeTypeId).isPresent()) {
			throw new EmployeeException("failed to delete the employee");

		}else {
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(" employee deleted sucessfully");
			return ResponseEntity.ok().body(messageDto);

		}
	}

	@Override
	public ResponseEntity<List<EmployeeTypeDto>> getAllEmployeeType() {
		List<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
		List<EmployeeTypeDto> employeeTypeDtos=new ArrayList<>();
		employeeTypes.stream().forEach(employeeType -> {
			EmployeeTypeDto employeeTypeDto=new  EmployeeTypeDto();
			BeanUtils.copyProperties(employeeType, employeeTypeDto);
			employeeTypeDtos.add(employeeTypeDto);
			
		});
		
		return ResponseEntity.ok().body(employeeTypeDtos);
	}


}
