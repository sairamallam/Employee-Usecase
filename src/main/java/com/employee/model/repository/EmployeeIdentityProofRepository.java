package com.employee.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeIdentityProof;
@Repository
public interface EmployeeIdentityProofRepository extends JpaRepository<EmployeeIdentityProof, Integer>{
	

}
