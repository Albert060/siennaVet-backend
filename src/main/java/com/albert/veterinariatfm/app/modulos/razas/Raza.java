package com.albert.veterinariatfm.app.modulos.razas;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "razas")
@Data
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRaza;

    @Column (name = "tipo_raza")
    String tipoRaza;

    @Column (name = "nombre")
    String nombre;


}
