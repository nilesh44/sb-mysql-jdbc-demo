package com.ace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//this annotation will scan all the @Bean  and create a spring bean for that in spring context
@Configuration
public class ApplicationBean {

	@Scope("singleton")
	// this annotation describe that create this bean only after depends on bean is
	// created
	// @DependsOn("dbProperties")
	// @Bean("databaseConfiguation")
	public DatabaseConfiguation getDatabaseConfiguation(DbProperties dbProperties) throws ClassNotFoundException {
		return new DatabaseConfiguation(dbProperties);
	}

}
