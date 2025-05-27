package com.example.salescarpremium.controllers;

import com.example.salescarpremium.dtos.CarDTO;
import com.example.salescarpremium.services.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.findAllService();
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.findOneServide(id).orElse(null);
    }

    @PostMapping()
    public CarDTO saveCar(@RequestBody CarDTO carDTO) {
        return carService.saveService(carDTO);
    }
}
