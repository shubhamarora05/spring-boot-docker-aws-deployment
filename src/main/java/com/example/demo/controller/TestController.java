package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/getdata")
	public Employee getData() {
		return testService.getData(); 
	}
}
