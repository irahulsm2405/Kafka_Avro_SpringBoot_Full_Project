package com.employee.ws.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.employee.ws.core.EmployeeEvent;

@Service
public class KafkaProducerService {
	
	//created a local variable with topic name
	public static final String TOPIC = "new-employee-created-event";
	
	@Autowired
	KafkaTemplate<String, EmployeeEvent> kafkaTemplate;
	
	//Changed here for Avro
	public void sendEmployeeEvent(EmployeeEvent employeeEvent) throws InterruptedException, ExecutionException {
		kafkaTemplate.send(TOPIC,String.valueOf(employeeEvent.getEmployeeId()), employeeEvent).get();
	}
	
	
}
