package com.example.salescarpremium.dao;

import com.example.salescarpremium.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<Car,Long> {
    public static void main(String[] args) {
        System.out.println("Hola, mundo");
    }
}
