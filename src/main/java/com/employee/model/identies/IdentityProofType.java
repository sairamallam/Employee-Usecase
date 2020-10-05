package com.employee.model.identies;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class IdentityProofType {
	@Id
	private Integer identityCardsTypeId;
	private String descriptionn;
}
