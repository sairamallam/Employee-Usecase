package com.employee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="EMPLOYEE_DETAILS")
//@Data
@Setter @Getter @ToString
public class EmployeeDetails implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeDesignation;
	private Double employeeSalary;


	

}
