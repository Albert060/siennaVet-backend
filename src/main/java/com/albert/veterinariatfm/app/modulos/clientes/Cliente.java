package com.albert.veterinariatfm.app.modulos.clientes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCliente;

    @Column(name = "nombre")
    String nombre;

    @Column (name = "apellido")
    String apellido;

    @Column(name = "dni")
    String dni;

    @Column (name = "direccion")
    String direccion;

    @Column (name = "telefono")
    String telefono;

    @Column (name = "codigo_postal")
    String codigoPostal;


}
