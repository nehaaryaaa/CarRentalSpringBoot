package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Car;

public interface CarService {

	Car addCar(Car car);

	List<Car> getAllCars();

	void deleteCarById(Long id);

	Car getCarById(Long id);

	Car updateCar(Car car);
}
