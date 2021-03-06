package com.employee.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeFamilyDeatils;
@Repository
public interface EmployeeFamilyDeatilsRepository extends JpaRepository<EmployeeFamilyDeatils, Integer> {

}
