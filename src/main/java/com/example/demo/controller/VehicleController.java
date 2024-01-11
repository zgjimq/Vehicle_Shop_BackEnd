package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vehicle;
import com.example.demo.exceptions.VehicleNotFoundException;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/vehicles")
@CrossOrigin()
@RequiredArgsConstructor
public class VehicleController {
	private final VehicleService vehicleService;
	private final VehicleRepository vehicleRepository;
	@GetMapping(path = "/all")
	public Iterable<Vehicle> getVehicles(){
		return vehicleService.getAllVehicles();
	}
	
	@PostMapping
	public ResponseEntity<?>createVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult results){
		if(results.hasErrors()) {
			Map<String, String> errors= new HashMap<>();
			for(FieldError fieldError : results.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors,HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(vehicleService.createOrUpdateVehicle(vehicle));
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> sellVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle not been found"));
		
		if(vehicle !=null) {
			vehicleService.sellVehicle(id);String message = "You have deleted vehicle with id: " + id;
        return ResponseEntity.ok().body(message);
		}
		else {
			String message = "You have not deleted vehicle with id: " + id;
	        return ResponseEntity.ok().body(message);
		}
		
	}
	
}
