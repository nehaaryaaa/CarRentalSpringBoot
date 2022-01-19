package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Car;
import com.neosoft.service.CarServiceImpl;

@Controller
public class CarController {

	@Autowired
	private CarServiceImpl carServiceImpl;
	
	@GetMapping("/owner")
	public String owner() {
		return "owner";
	}
	
	@GetMapping("/cars")
	public String listCars(Model model) {
		
		model.addAttribute("cars",carServiceImpl.getAllCars());
		
		return "view_car";
	}
	
	@GetMapping("/admin/viewcars")
	public String viewCars(Model model) {
		
		model.addAttribute("cars",carServiceImpl.getAllCars());
		
		return "admin_view_car";
	}
	
	@GetMapping("/cars/new")
	public String createCarForm(Model model) {
		
		Car car = new Car();
		model.addAttribute("car", car);
		
		return "create_car";
	}
	
	@PostMapping("/cars")
	public String saveCar(@ModelAttribute("car") Car car) {
		
		carServiceImpl.addCar(car);
		
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/{id}")
	public String deleteCar(@PathVariable Long id) {
		
		carServiceImpl.deleteCarById(id);
		
		return "redirect:/cars";
	}	

}
