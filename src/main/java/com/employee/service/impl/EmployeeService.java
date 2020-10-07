package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDetailsDto;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeDetails;
import com.employee.model.repository.EmployeeDetailsRepository;
import com.employee.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public ResponseEntity<String> registration(List<EmployeeDetailsDto> employeeDetailsDtos) {

		List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
		employeeDetailsDtos.stream().forEach(employeeDetailsDto -> {
			EmployeeDetails employeeDetails = new EmployeeDetails();
			BeanUtils.copyProperties(employeeDetailsDto, employeeDetails);
			employeeDetailsList.add(employeeDetails);
		});
		

		List<EmployeeDetails> employeeDetailsListResonse = employeeDetailsRepository.saveAll(employeeDetailsList);
		return new ResponseEntity<>("employee sucsessfully registerd", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> update(EmployeeDetailsDto employeeDetailsDto) {
		if (!employeeDetailsRepository.findById(employeeDetailsDto.getEmployeeId()).isPresent()) {
			throw new EmployeeException("employee not existed");
		}

		EmployeeDetails employeeDetails = new EmployeeDetails();
		BeanUtils.copyProperties(employeeDetailsDto, employeeDetails);
		employeeDetailsRepository.save(employeeDetails);
		return new ResponseEntity<>("employee sucsessfully updated", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeDetails> getEmployee(Long employeeId) {
		Optional<EmployeeDetails> employeeDetails = employeeDetailsRepository.findById(employeeId);
		if (!employeeDetails.isPresent()) {
			throw new EmployeeException("employee not existed");
		} else {
			return new ResponseEntity<>(employeeDetails.get(), HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<List<EmployeeDetailsDto>> getAllEmployee() {
		List<EmployeeDetails> employeeDetailsList= employeeDetailsRepository.findAll();
		
		List<EmployeeDetailsDto> employeeDetailsDtoList=new ArrayList<>();
		employeeDetailsList.stream().forEach(employeeDetails->{
			EmployeeDetailsDto employeeDetailsDto=new EmployeeDetailsDto();
			BeanUtils.copyProperties(employeeDetails, employeeDetailsDto);
			employeeDetailsDtoList.add(employeeDetailsDto);
		});

		return new ResponseEntity<>(employeeDetailsDtoList, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long employeeId) {
		if (!employeeDetailsRepository.findById(employeeId).isPresent()) {
			throw new EmployeeException("employee not existed");
		} else {
			employeeDetailsRepository.deleteById(employeeId);
			return new ResponseEntity<>(employeeId + " deleted succsessfully", HttpStatus.OK);
		}
	}

}
