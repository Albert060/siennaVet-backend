package com.albert.veterinariatfm.app.modulos.citas;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase donde se van a gestionar los parametros (Variable) de citas que se van a solicitar para los diferentes
 * registro y comunicacion con la base de dato.
 */
@Entity
@Data
@Table (name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCita;

    @Column (name = "fecha")
    LocalDate fecha;

    @Column (name = "detalles")
    String detalles;

    @Column (name = "hora")
    LocalTime hora;

    @Column (name = "id_ficha")
    Long idFicha;

    @Column (name = "id_vet")
    Long idVet;
}
