package com.employee.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.employee.model.identies.IdentityProofType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class EmployeeIdentityProof {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeIdentityProofId;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeDetails employeeDetails;
	private String identityProofValue;
	@ManyToOne
	@JoinColumn(name="identity_proof_type_id")
	private IdentityProofType identityProofType;
	
	private String employeeIdentityProofPath;
	
	
	
	//madetory fields
	private LocalDateTime entryDate;
	private Long	entryUser;
	private LocalDateTime removeDate;
	private Long removeUser;
	private String recordStatus;
	
}
