package com.employee.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeFamilyDeatilsDto {

	private Integer employeFamilyDetailsId;
	private Integer relationShipId;
	private String name; 
	private String identityNumber;
	private Integer identityProofTypeId;
	private Long employeeId;
	
	
	
	//madetory fields
//	private LocalDateTime entryDate;
//	private Integer	entryUser;
//	private LocalDateTime removeDate;
//	private Integer removeUser;
//	private String recordStatus;

}
