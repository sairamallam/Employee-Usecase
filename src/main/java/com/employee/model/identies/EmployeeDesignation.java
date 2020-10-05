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
public class EmployeeDesignation {
	
	
	
	@Id
	@Length(max = 15)
	private String employeeDesignationId;
	private String designation;

}
