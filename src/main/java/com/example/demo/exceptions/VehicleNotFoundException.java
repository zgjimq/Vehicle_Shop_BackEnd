package com.example.demo.exceptions;

public class VehicleNotFoundException extends RuntimeException{
	public VehicleNotFoundException(String message) {
		super(message);
	}
}
