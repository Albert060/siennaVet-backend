package com.albert.veterinariatfm.app.modulos.jaulas;

import jakarta.persistence.*;
import lombok.Data;

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
