package com.ace.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app.db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DbProperties {

	private String url;
	private String user;
	private String password;
	private String driverClass;
	
}
