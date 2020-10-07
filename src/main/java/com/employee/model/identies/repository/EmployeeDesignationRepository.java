package com.employee.model.identies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.identies.EmployeeDesignation;
@Repository
public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, Integer> {

}
