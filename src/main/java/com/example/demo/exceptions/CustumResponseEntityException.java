package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustumResponseEntityException extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	 public final ResponseEntity<?> handleVehicleNotFoundException(VehicleNotFoundException ex){
		 VehicleNotFoundExceptionResponse vehicleNotFoundExceptionResponse = new VehicleNotFoundExceptionResponse(ex.getMessage());
		 return new ResponseEntity<>(vehicleNotFoundExceptionResponse, HttpStatus.BAD_REQUEST );
	 }
	 
	

}
