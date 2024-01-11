package com.example.demo.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.exceptions.VehicleNotFoundException;
import com.example.demo.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class VehicleService {
	private final VehicleRepository vehicleRepository;
	
	
	public Vehicle createOrUpdateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	
	
	public ResponseEntity<?> sellVehicle(Long id){
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()->
		 new VehicleNotFoundException("Vehicle with this id doesnt exist"));
		
		vehicleRepository.delete(vehicle);
		String message="U have deleted "+id+" id";
		return ResponseEntity.ok().body(message);
	}
	


	
	public List<Vehicle>getAllVehicles(){
		return vehicleRepository.findAll();
	}
	
}
