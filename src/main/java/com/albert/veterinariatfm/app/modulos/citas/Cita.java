package com.albert.veterinariatfm.app.modulos.citas;

import jakarta.persistence.*;

@Entity
@Table (name = "citas")

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCita;

    @Column (name = "fecha")
    String fecha;

    @Column (name = "detalles")
    String detalles;

    @Column (name = "hora")
    String hora;

    @Column (name = "idAnimal")
    Long idAnimal;

    @Column (name = "idVet")
    Long idVet;
}
