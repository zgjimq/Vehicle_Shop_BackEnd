package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long id;
	@NotBlank(message = "Manufacturer needs to be filled")
	@Size(min = 3, max = 20, message = "Manufacturer size is incorrect")
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@NotBlank(message = "Model needs to be filled")
	@Size(min = 1, max = 20, message = "Model size is incorrect")
	@Column(name = "model")
	private String model;
	
	
	//@NotBlank(message = "Price needs to be filled")
	//@Size(min = 500, max = 1000000, message = "Price is incorrect")
	@Min(value=500, message = "Price of the car needs to be bigger then 500")
	@Max(value=10000000, message = "Price of the car needs to be less then 1000000")
	@Column(name = "price")
	private int price;
	
	//@NotBlank(message = "Horse Power needs to be filled")
	//@Size(min = 60, max = 1500, message = "Horse Power is incorrect")
	@Min(value = 60, message = "Ps of the car is incorrect")
	@Max(value = 3000, message = "Ps of the car is incorrect")
	@Column(name = "horsePower")
	private int horsePower;
	
	@NotBlank(message = "Color needs to be filled")
	@Size(min = 2,max = 25,message = "Color is incorrect")
	@Column(name = "color")
	private String color;
	
	//@NotBlank(message = "Mileage needs to be filled")
	//@Positive(message = "Mileage needs to be positive number")
	@Positive(message = "Mileage should be an positive number")
	@Max(value = 1000000, message = "Mileage is incorrect")
	@Column(name = "mileage")
	private int mileage;
	
	//@NotBlank(message = "Production year needs to be filled")
	//@Size(min = 1850, max = 2024, message = "Production year is incorrect")
	@Min(value = 1800, message = "Production year is incorrect")
	@Max(value = 2024,message = "Year should be in between 1800 and 2024")
	@Column(name = "productionYear")
	private int productionYear;
	
	@NotBlank(message = "Trasnsmission needs to be filled")
	@Size(min = 3, max = 15, message = "Trasnsmission is incorrect")
	@Column(name = "transmission")
	private String transmission;
	
	@NotBlank(message = "Fuel type needs to be filled")
	@Size(min = 3, max = 15, message = "Fuel type is incorrect")
	@Column(name = "fuelType")
	private String fuelType;
	
}
