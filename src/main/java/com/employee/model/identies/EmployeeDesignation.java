package com.employee.model.identies;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@ToString
public class EmployeeDesignation {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeDesignationId;
	private String employeeDesignationValue;
	
	
	//madetory fields
	private LocalDateTime entryDate;
	private Long	entryUser;
	private LocalDateTime removeDate;
	private Long removeUser;
	private String recordStatus;
	

}
