package com.employee.ws;


import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeKafkaIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeKafkaIntegrationApplication.class, args);
		System.out.println("************************************");
		System.out.println("Application restarted at: " + LocalTime.now());
		System.out.println("************************************");
	}

}
