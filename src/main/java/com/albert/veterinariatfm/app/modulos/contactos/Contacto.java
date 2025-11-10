package com.albert.veterinariatfm.app.modulos.contactos;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table (name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idContacto;

    @Column (name = "nombre")
    String nombre;

    @Column (name = "email")
    String email;

    @Column (name = "servicio")
    String servicio;

    @Column (name = "mensaje")
    String mensaje;
}
