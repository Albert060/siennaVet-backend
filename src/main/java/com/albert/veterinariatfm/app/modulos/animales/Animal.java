package com.albert.veterinariatfm.app.modulos.animales;

import jakarta.persistence.*;

@Entity
@Table (name = "animales")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAnimal;

    @Column (name = "nombre")
    String nombre;
}
