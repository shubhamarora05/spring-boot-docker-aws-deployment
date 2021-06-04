package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ApiTest extends TestapiApplicationTests{

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/api/v1/getdata")).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Shubham")).andExpect(jsonPath("$.departmentName").value("IT"))
				.andExpect(jsonPath("$.organisation").value("Test")).andExpect(jsonPath("$.employeeId").value(1234));

	}
}
