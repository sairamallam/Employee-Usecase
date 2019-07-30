package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeDetails;
import com.employee.repository.EmployeeDetailsRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public ResponseEntity<String> registration(EmployeeDetails employeeDetails) {

		employeeDetailsRepository.save(employeeDetails);
		return new ResponseEntity<>("employee sucsessfully registerd", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> update(EmployeeDetails employeeDetails) {
		if (!employeeDetailsRepository.findById(employeeDetails.getEmployeeId()).isPresent())
			throw new EmployeeException("employee not existed");

		employeeDetailsRepository.save(employeeDetails);
		return new ResponseEntity<>("employee sucsessfully updated", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<EmployeeDetails> getEmployee(Long employeeId) {
		return new ResponseEntity<>(employeeDetailsRepository.findById(employeeId).get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<EmployeeDetails>> getAllEmployee() {
		return new ResponseEntity<>(employeeDetailsRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long employeeId) {
		if (!employeeDetailsRepository.findById(employeeId).isPresent())
			throw new EmployeeException("employee not existed");

		employeeDetailsRepository.deleteById(employeeId);
		return new ResponseEntity<>(employeeId + " deleted succsessfully", HttpStatus.OK);
	}

}
