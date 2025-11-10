package com.albert.veterinariatfm.app.modulos.vets;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase donde se van a gestionar los parametros (Variable) de veterinario que se van a solicitar para los diferentes
 * registro y comunicacion con la base de dato.
 */
@Data
@Entity
@Table (name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVet;

    @Column (name = "nombre")
    String nombre;

    @Column (name = "apellido")
    String apellido;

    @Column (name = "dni")
    String dni;

    @Column (name = "sexo")
    String sexo;

    @Column (name = "num_colegiado")
    String numColegiado;

    @Column (name = "email")
    String email;

    @Column (name = "contrasena")
    String contrasena;

    @Column (name = "telefono")
    String telefono;

    @Column (name = "fecha_inicio")
    String fechaInicio;

    @Override
    public String toString() {
        return "Vet{" +
                "idVet=" + idVet +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo='" + sexo + '\'' +
                ", numColegiado='" + numColegiado + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                '}';
    }
}
