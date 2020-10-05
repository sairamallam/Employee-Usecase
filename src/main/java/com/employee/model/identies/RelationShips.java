package com.employee.model.identies;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class RelationShips {
	@Id
	@Length(max = 15)
	private String relationShipId;
	private String description;

}
