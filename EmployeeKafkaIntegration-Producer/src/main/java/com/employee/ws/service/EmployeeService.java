package com.employee.ws.service;

import org.springframework.stereotype.Service;

import com.employee.ws.entity.EmployeeEntity;


public interface EmployeeService {
		public EmployeeEntity addNewEmployee(EmployeeEntity employee) throws Exception;
}
