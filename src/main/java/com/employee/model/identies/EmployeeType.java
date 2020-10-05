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
public class EmployeeType {
	@Id
	private Integer employeeTypeId;
	private String description;

}
