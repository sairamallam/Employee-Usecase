package com.employee;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeDetails;
import com.employee.repository.EmployeeDetailsRepository;
import com.employee.service.EmployeeService;
import com.employee.service.IEmployeeService;


@RunWith(SpringRunner.class)
public class TestEmployeeService {

	@Mock EmployeeDetailsRepository employeeDetailsRepository;
	@InjectMocks EmployeeService iEmployeeService;
	
	EmployeeDetails employeeDetails;
	
	
	@Before
	public void setup() {
		
		employeeDetails=new EmployeeDetails();
		employeeDetails.setEmployeeAddress("addreess");
		employeeDetails.setEmployeeDesignation("SSE");
		employeeDetails.setEmployeeId(1L);
		employeeDetails.setEmployeeName("sai");
		employeeDetails.setEmployeeSalary(5000D);
	}
	
	@Test
	public void registrationTest() {
		
		Mockito.when(employeeDetailsRepository.save(employeeDetails)).thenReturn(employeeDetails);
		ResponseEntity<String> actualvalue = iEmployeeService.registration(employeeDetails);
        Assert.assertEquals("employee sucsessfully registerd", actualvalue.getBody());
		
	}
	
	
	/*
	 * @Test(expected=EmployeeException.class) public void
	 * registrationNegativeTest() {
	 * 
	 * Mockito.when(employeeDetailsRepository.save(employeeDetails)).thenReturn(null
	 * ); ResponseEntity<String> actualvalue =
	 * iEmployeeService.registration(employeeDetails); //
	 * Assert.assertEquals("employee not registerd", actualvalue.getBody());
	 * 
	 * }
	 */
	 
	
	@Test
	public void updateTest() {
		
		Mockito.when(employeeDetailsRepository.save(employeeDetails)).thenReturn(employeeDetails);
		Mockito.when(employeeDetailsRepository.findById(employeeDetails.getEmployeeId())).thenReturn(Optional.of(employeeDetails));

		ResponseEntity<String> actualvalue = iEmployeeService.update(employeeDetails);
        Assert.assertEquals("employee sucsessfully updated", actualvalue.getBody());
		
	}
	
	@Test(expected=EmployeeException.class)
	public void updateNegativeTest() {
		Mockito.when(employeeDetailsRepository.save(employeeDetails)).thenReturn(employeeDetails);
		Mockito.when(employeeDetailsRepository.findById(2L)).thenReturn(Optional.of(employeeDetails));

		ResponseEntity<String> actualvalue = iEmployeeService.update(employeeDetails);
        Assert.assertEquals("employee not updated", actualvalue.getBody());
		
	}
	
	@Test
	public void getEmployeeTest() {
		Mockito.when(employeeDetailsRepository.findById(employeeDetails.getEmployeeId())).thenReturn(Optional.of(employeeDetails));

		ResponseEntity<EmployeeDetails> actualvalue = iEmployeeService.getEmployee(employeeDetails.getEmployeeId());
        Assert.assertEquals(employeeDetails, actualvalue.getBody());
		
	}
	
	@Test
	public void getAllEmployeeTest() {
		List<EmployeeDetails> list=new ArrayList<>();
		list.add(employeeDetails);
		Mockito.when(employeeDetailsRepository.findAll()).thenReturn(list);

		ResponseEntity<List<EmployeeDetails>> actualvalue = iEmployeeService.getAllEmployee();
        Assert.assertEquals(list.size(), actualvalue.getBody().size());
		
	}
	
	@Test
	public void deleteEmployeeTest() {
		Mockito.when(employeeDetailsRepository.findById(employeeDetails.getEmployeeId())).thenReturn(Optional.of(employeeDetails));

		ResponseEntity<String> actualvalue = iEmployeeService.deleteEmployee(employeeDetails.getEmployeeId());
        Assert.assertEquals("1 deleted succsessfully", actualvalue.getBody());
		
	}

	@Test(expected = EmployeeException.class)
	public void deleteEmployeeNegativeTest() {
		Mockito.when(employeeDetailsRepository.save(employeeDetails)).thenReturn(employeeDetails);
		Mockito.when(employeeDetailsRepository.findById(2L)).thenReturn(Optional.of(employeeDetails));

		ResponseEntity<String> actualvalue = iEmployeeService.deleteEmployee(employeeDetails.getEmployeeId());
		Assert.assertEquals("1 deleted succsessfully", actualvalue.getBody());

	}
	 
}
