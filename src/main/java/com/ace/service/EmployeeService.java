package com.ace.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {

	public ResponseEntity<Object> findByEmpId(BigInteger bigInteger);
}
