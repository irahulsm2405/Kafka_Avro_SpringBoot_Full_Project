package com.employee.ws.Exception;

public class FailedToAddEmployeeException extends RuntimeException{
		public FailedToAddEmployeeException(String message) {
			super(message);
		}
}
