package com.example.salescarpremium.services.impl;

import com.example.salescarpremium.dao.CarDAO;
import com.example.salescarpremium.dtos.CarDTO;
import com.example.salescarpremium.entities.Car;
import com.example.salescarpremium.services.interfaces.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CarDTO> findAllService() {
        List<Car> cars = carDAO.findAll();
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<CarDTO> findOneServide(Long id) {
        return carDAO.findById(id)
                .map(car -> modelMapper.map(car, CarDTO.class));

    }

    @Override
    public CarDTO saveService(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        return  modelMapper.map(carDAO.save(car), CarDTO.class);
    }
}
