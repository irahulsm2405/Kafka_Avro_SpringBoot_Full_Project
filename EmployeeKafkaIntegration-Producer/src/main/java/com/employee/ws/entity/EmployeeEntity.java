package com.employee.ws.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public class EmployeeEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int employeeId;
		private String name;
		private String unit;
		private String email;
		private String phone;
		
		public Integer getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public EmployeeEntity(Integer employeeId, String name, String unit, String email, String phone) {
			super();
			this.employeeId = employeeId;
			this.name = name;
			this.unit = unit;
			this.email = email;
			this.phone = phone;
		}
		public EmployeeEntity() {
			
		}
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", name=" + name + ", unit=" + unit + ", email=" + email
					+ ", phone=" + phone + "]";
		}
		
		
}
