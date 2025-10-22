package com.albert.veterinariatfm.app.modulos.fichas;

import jakarta.persistence.*;

@Entity
@Table (name = "fichas")

public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFicha;

    @Column (name = "nombre")
    String nombre;

    @Column (name = "sexo")
    String sexo;

    @Column (name = "edad")
    String edad;

    @Column (name = "peso")
    String peso;

    @Column (name = "chip")
    String chip;

    @Column (name = "idAnimal")
    Long idAnimal;

    @Column (name = "idRaza")
    Long idRaza;

    @Column (name = "idCliente")
    Long idCliente;

}
