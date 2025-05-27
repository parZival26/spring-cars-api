package com.example.salescarpremium.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars_premium")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String marca;
    private String linea;
    private String color;

    @Column(length = 4)
    private Integer model;
    private String placa;
    private LocalDate fechafabri;


}
