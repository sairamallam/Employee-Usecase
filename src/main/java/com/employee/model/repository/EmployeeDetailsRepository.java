package com.employee.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository  extends JpaRepository<EmployeeDetails, Long> {

	
}
