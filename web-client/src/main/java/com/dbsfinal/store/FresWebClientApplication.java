package com.dbsfinal.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FresWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FresWebClientApplication.class, args);
	}
}
