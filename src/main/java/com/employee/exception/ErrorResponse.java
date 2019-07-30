package com.employee.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class ErrorResponse {
	
	private String message;

}