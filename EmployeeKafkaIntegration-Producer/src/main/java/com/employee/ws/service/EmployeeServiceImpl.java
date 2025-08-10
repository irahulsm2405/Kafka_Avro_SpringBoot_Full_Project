package com.employee.ws.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.ws.entity.EmployeeEntity;
import com.employee.ws.core.EmployeeEvent;
import com.employee.ws.event.EmployeeEventMap;
import com.employee.ws.kafka.KafkaProducerService;
import com.employee.ws.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	KafkaProducerService kafkaProducerService;
	
	@Transactional
	@Override
	public EmployeeEntity addNewEmployee(EmployeeEntity employee) throws InterruptedException, ExecutionException {
		
	EmployeeEntity newEmployee = employeeRepository.save(employee);
	
	EmployeeEvent employeeEvent = EmployeeEventMap.mapToEvent(newEmployee);
	 
	//Kafka code here
	kafkaProducerService.sendEmployeeEvent(employeeEvent);
	
	return newEmployee;
	}

}
