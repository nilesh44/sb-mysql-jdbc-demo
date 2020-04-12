package com.ace.repo;

import java.math.BigInteger;

import com.ace.entity.Employee;

public interface EmployeeRepository {

	public Employee findByEmpId(BigInteger bigInteger);
	
}
