package com.employee.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SampleTestingClass {
	
	
	
	
	
	
	public static void main(String args[]) {
		
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> getWithoutHeader = restTemplate.getForEntity("http://dummy.restapiexample.com/api/v1/employees", String.class);
		
	System.out.println("getWithoutHeader= "+getWithoutHeader);
	
	}

}
