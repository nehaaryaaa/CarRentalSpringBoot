package com.neosoft.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car{
	
	@Id
	@Column(name = "car_id")
	private long carid;
	
	@NotNull
	@Column(name = "car_registration_no")
	@Size(max = 15)
	private String carregistrationno; 
	
	@NotNull
	@Column(name = "car_name")
	private String carname;
	
	@NotNull
	@Column(name = "quantity")
	private int quantity;
	
	@NotNull
	@Column(name = "issued")
	private int issued;
	
	@NotNull
	@Column(name = "cost_per_mile")
	private double costpermile;
	
}

/* CREATE TABLE IF NOT EXISTS CAR
(
carId INT Primary Key,
carRegistrationNo INT,
carName Varchar(100),
carStatus Varchar(100),
costPerMile double(100,4),
quantity INT,
issued INT,

); */