package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.identies.EmployeeDesignation;

public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, String> {

}
