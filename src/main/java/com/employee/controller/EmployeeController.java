package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDetailsDto;
import com.employee.model.EmployeeDetails;
import com.employee.model.identies.EmployeeDesignation;
import com.employee.model.identies.EmployeeType;
import com.employee.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	IEmployeeService iEmployeeService;

	@PostMapping("/registration")
	public ResponseEntity<String> registration(@RequestBody List<EmployeeDetailsDto> employeeDetailsDtos) {
		return iEmployeeService.registration(employeeDetailsDtos);

	}

	@PutMapping("/updation")
	public ResponseEntity<String> update(@RequestBody EmployeeDetailsDto employeeDetailsDto) {
		return iEmployeeService.update(employeeDetailsDto);

	}

	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable("employeeId") Long employeeId) {
		return iEmployeeService.getEmployee(employeeId);

	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDetailsDto>> getAllEmployee() {

		return iEmployeeService.getAllEmployee();

	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		return iEmployeeService.deleteEmployee(employeeId);

	}

	
	// Designations operatios
	@PostMapping("/designations")
	public void addEployeeDesignation(@RequestBody EmployeeDesignation employeeDesignation) {

	}

	@DeleteMapping("/designations/{designationId}")
	public void removeEmployeeDesignation(@PathVariable(name = "designationId") String employeeDesignationId) {

	}

	@GetMapping("/designations")
	public void getAllEmployeeDesignation() {

	}
	@GetMapping("/designations/{designationId}")
	public void getEmployeeDesignation(@PathVariable("designationId") String designationId) {

	}
	

	// Employeetype operatios
	@PostMapping("/type")
	public void addEmployeeType(@RequestBody EmployeeType employeeType) {
		
	}
	
	@DeleteMapping("/type/{employeeTypeId}")
	public void removeEmployeeType(@PathVariable("employeeTypeId") String employeeTypeId) {
		
	}
	@GetMapping("/type/{employeeTypeId}")
	public void getEmployeeType(@PathVariable("employeeTypeId") String employeeTypeId) {
		
	}
	@GetMapping("/type")
	public void getAllEmployeeType() {
		
	}
	

	// identity proofs type operations

	// RelationShip operations

}
