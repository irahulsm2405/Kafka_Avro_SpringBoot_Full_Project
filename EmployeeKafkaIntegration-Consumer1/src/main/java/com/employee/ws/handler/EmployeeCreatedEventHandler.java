package com.employee.ws.handler;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.employee.ws.core.EmployeeEvent;

@Service
@KafkaListener(topics="new-employee-created-event")
public class EmployeeCreatedEventHandler {
	
//  Method will be invoked automatically when a message is pushed to the topic, no need to manually call it
//	@KafkaListener(topics="new-employee-created-event") can be replaced by @KafkaListner to class and @KafkaHandler to each method
	@KafkaHandler
	public void handle(EmployeeEvent employee) {
		System.out.println("Sending an email to: " + employee.getName() + " : " + employee.getEmail());
	}
}

