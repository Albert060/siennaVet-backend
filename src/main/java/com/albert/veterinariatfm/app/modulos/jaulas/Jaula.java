package com.albert.veterinariatfm.app.modulos.jaulas;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase donde se van a gestionar los parametros (Variable) de Jaulas que se van a solicitar para los diferentes
 * registro y comunicacion con la base de dato.
 */
@Entity
@Table (name = "jaulas")
@Data
public class Jaula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idJaula;

    @Column (name = "tamano")
    String tamano;

    @Column (name = "disponibilidad")
    String disponibilidad;
}
