package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeDetails;
import com.employee.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
@Autowired IEmployeeService iEmployeeService;
	@PostMapping("/registration")
	public ResponseEntity<String> registration(@RequestBody EmployeeDetails employeeDetails){
		return iEmployeeService.registration(employeeDetails);
		
	}
	@PutMapping("/updation")
	public ResponseEntity<String> update(@RequestBody EmployeeDetails employeeDetails){
		return iEmployeeService.update(employeeDetails);
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable("employeeId") Long employeeId){
		return iEmployeeService.getEmployee(employeeId);
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDetails>> getAllEmployee(){
		return iEmployeeService.getAllEmployee();
		
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId")Long employeeId){
		return iEmployeeService.deleteEmployee(employeeId);
		
	}

}
