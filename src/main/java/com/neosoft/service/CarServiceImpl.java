package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Car;
import com.neosoft.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public void deleteCarById(Long id) {
		carRepository.deleteById(id);
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findById(id).get();
	}

	@Override
	public Car updateCar(Car existingCar) {
		return carRepository.save(existingCar);
	}

}
