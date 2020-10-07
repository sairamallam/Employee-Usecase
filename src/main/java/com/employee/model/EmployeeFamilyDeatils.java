package com.employee.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.employee.model.identies.IdentityProofType;
import com.employee.model.identies.RelationShips;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class EmployeeFamilyDeatils {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeFamilyDetailsId;
	@ManyToOne
	@JoinColumn(name="relationShip_id")
	private RelationShips relationShips;
	private String name; 
	private String identityNumber;
	@ManyToOne
	@JoinColumn(name="identity_proof_type_id")
	private IdentityProofType identityProofType;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeDetails employeeDetails;
	
	
	
	//madetory fields
	private LocalDateTime entryDate;
	private Long	entryUser;
	private LocalDateTime removeDate;
	private Long removeUser;
	private String recordStatus;
	
}
