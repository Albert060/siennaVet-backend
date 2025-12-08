package com.albert.veterinariatfm.app.modulos.razas;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase donde se van a gestionar los parametros (Variable) de raza, que se van a solicitar para los diferentes
 * registro y comunicacion con la base de dato.
 */
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
