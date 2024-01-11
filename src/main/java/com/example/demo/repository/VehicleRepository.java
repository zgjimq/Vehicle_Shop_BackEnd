package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	public Optional<Vehicle> findById(Long id);
}
