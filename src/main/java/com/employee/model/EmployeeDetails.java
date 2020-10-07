package com.employee.model;

import java.io.Serializable;
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
public class EmployeeDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	//self details
	private String title;
	private String surname;
	private String firstName;
	private String middleName;
	private String dateOfBirth;
	private String marrigeStatus;
	private String email;
	private String phone;
	private String altPhone;


	private String countryOfBirth;
	private String state;
	private String district;
	private String address;
	private String pinCode;   

	
	//identity cards
	
//	private String aadhar;
//	private String panNumber;
//	private String rationCard;
//	

	//Foreign keys
//	private String employeeDesignationId;
//	private String employeeType;
//	private String guardianId;


	
	//Bank details
	private Double employeeSalaryPackage;
	private String accountNumber;
	private String ifscCode;
	private String pfNumber;
	private String pfUan;
	private String esiNumber;
	private String photoPath;
	
	//madetory fields
	private LocalDateTime entryDate;
	private Integer	entryUser;
	private LocalDateTime removeDate;
	private Integer removeUser;
	private String recordStatus;
	

}
