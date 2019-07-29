package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.EmployeeDetails;

public interface EmployeeDetailsRepository  extends JpaRepository<EmployeeDetails, Long> {

	
	
}
