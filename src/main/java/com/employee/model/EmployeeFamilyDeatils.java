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
public class EmployeeFamilyDeatils {
	@Id
	private Integer employeFamilyDetailsId;
	private String relationShipId; /*RelationShips table Id*/
	private String name;
	private String identityNumber;
	private String identityProofTypeId; /* IdentityCardsType id*/
	
}
