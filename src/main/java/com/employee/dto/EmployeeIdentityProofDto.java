package com.employee.dto;

import java.io.File;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeIdentityProofDto {

	private Integer employeeIdentityProofId;
	private Long employeeId;
	private String identityProofValue;
	private Integer identityProofTypeId;
	private File employeeIdentityProofFile;

}
