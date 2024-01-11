package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleNotFoundExceptionResponse {
	private String vehicleNotFoundMessage;
	
	public VehicleNotFoundExceptionResponse(String message) {
		super();
		this.vehicleNotFoundMessage=message;
	}
}
