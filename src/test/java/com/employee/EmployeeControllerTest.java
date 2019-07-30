package com.employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employee.controller.EmployeeController;
import com.employee.model.EmployeeDetails;
import com.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmployeeControllerTest {

	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeController employeeController;

	private MockMvc mockMvc;

	EmployeeDetails employeeDetails;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		employeeDetails = new EmployeeDetails();
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void reggistrationTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/employee/registration").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeDetails))).andExpect(status().isOk());

	}

	@Test
	public void upadate() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.put("/employee/updation").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeDetails))).andExpect(status().isOk());

	}

	@Test
	public void getEmployeeTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/employee/employees/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeDetails))).andExpect(status().isOk());

	}

	@Test
	public void getAllEmployeeTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/employee/employees").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeDetails))).andExpect(status().isOk());

	}

	@Test
	public void deleteEmployeeTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/employee/employees/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeDetails))).andExpect(status().isOk());

	}
}
