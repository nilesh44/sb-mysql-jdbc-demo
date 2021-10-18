package com.ace.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfiguation {

	private String url;
	private String driverClass;
	private String userName;
	private String password;

	public DatabaseConfiguation(DbProperties dbProperties) throws ClassNotFoundException {
		super();

		this.url = dbProperties.getUrl();
		this.driverClass = dbProperties.getDriverClass();
		this.userName = dbProperties.getUser();
		this.password = dbProperties.getPassword();
		loadDriverClass();
	}

	private void loadDriverClass() throws ClassNotFoundException {

		Class.forName(this.driverClass);

		System.out.println("MySQL JDBC Driver Registered!");
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(this.url, this.userName, this.password);
			System.out.println("SQL Connection to database established!");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}

}

