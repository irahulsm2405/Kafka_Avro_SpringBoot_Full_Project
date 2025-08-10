package com.employee.ws.event;

import com.employee.ws.core.EmployeeEvent;
import com.employee.ws.entity.EmployeeEntity;

public class EmployeeEventMap {

	public static EmployeeEvent mapToEvent(EmployeeEntity newEmployee) {
		    return EmployeeEvent.newBuilder()
		            .setEmployeeId(newEmployee.getEmployeeId())
		            .setName(newEmployee.getName())
		            .setUnit(newEmployee.getUnit())
		            .setEmail(newEmployee.getEmail())
		            .setPhone(newEmployee.getPhone())
		            .build();
		}

	}
