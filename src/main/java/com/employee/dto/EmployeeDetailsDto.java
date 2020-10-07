package com.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDetailsDto {

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

	
	//Bank details
	private Double employeeSalaryPackage;
	private String accountNumber;
	private String ifscCode;
	private String pfNumber;
	private String pfUan;
	private String esiNumber;

}
