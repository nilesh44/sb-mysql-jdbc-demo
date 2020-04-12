package com.ace.repo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ace.config.DatabaseConfiguation;
import com.ace.config.DbProperties;
import com.ace.entity.Employee;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private DbProperties dbProperties;
	
	@Autowired 
	@Qualifier("DatabaseConfiguation")
    private DatabaseConfiguation  databaseConfiguation;
	
	@Override
	public Employee findByEmpId(BigInteger empId) {
		Employee employee= new Employee();
		String sql="select * from employee where emp_id=?";
		//try with resources
		//Connection connection= databaseConfiguation.getConnection();
		Connection connection=null;
		//try with resources example
		//try(Connection connection= databaseConfiguation.getConnection()) {
		try {
			 connection= databaseConfiguation.getConnection();
			PreparedStatement preparedStatement=	connection.prepareStatement(sql);
			preparedStatement.setBigDecimal(1, BigDecimal.valueOf(empId.longValue()));
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
			employee.setEmpId(resultset.getBigDecimal("emp_id").toBigInteger());
			employee.setEmpFn(resultset.getString("emp_fn"));
			employee.setEmpLn(resultset.getString("emp_ln"));
				
			}
			System.out.println(employee);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//good practice
		
		//every connection need to be closed after the query is executed successfuly(if we use direct jdbc )
		//(if we are using connection pooling then we need not to close the connection it was managed by the connection pooling third party jar)
		//if we will use try with resources then there is no need to write the finally block
		//try with resources will automatically close the connection after try or catch block executed
		
		finally {
            try
            {
                if(connection != null)
                	System.out.println(" THREAD NAME  "+Thread.currentThread().getName());
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		if(employee.getEmpId()==null)
		{
		return null;
		
		
		}
		return employee;
	}

}
