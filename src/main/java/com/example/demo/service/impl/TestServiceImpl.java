package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public Employee getData() {
		Employee e = new Employee();
		e.setName("Shubham");
		e.setDepartmentName("IT");
		e.setEmployeeId(1234);
		e.setOrganisation("Test");
		return e;
	}

}
