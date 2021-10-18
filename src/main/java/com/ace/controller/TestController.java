package com.ace.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ace.service.EmployeeService;

@RestController
public class TestController {

	@Autowired
	private EmployeeService employeeService;
	
	//example of using requestparam
	//http://localhost:8080/test?emp_id=10
	
	  @GetMapping("/test") public ResponseEntity<Object> test(@RequestParam
	  BigInteger emp_id) {
	  
	  return employeeService.findByEmpId(emp_id);
	  
	  }
	 
	  //example of PathVariable
	
	//http://localhost:8080/test/1
	/*
	 * @GetMapping("/test/{emp_id}") public ResponseEntity<Object>
	 * test(@PathVariable BigInteger emp_id) {
	 * 
	 * return employeeService.findByEmpId(emp_id);
	 * 
	 * }
	 */
	
}
