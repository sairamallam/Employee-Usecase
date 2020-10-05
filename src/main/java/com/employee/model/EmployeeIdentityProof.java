package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class EmployeeIdentityProof {
	@Id
	private Integer employeeIdentityProofId;
	private Long employeeId;
	private String IdentityProofValue;
	private Integer IdentityProofTypeId;
}
