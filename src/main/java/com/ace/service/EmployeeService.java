package com.ace.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.ace.entity.Employee;

public interface EmployeeService {

	public ResponseEntity<Object> findByEmpId(BigInteger bigInteger);
}
