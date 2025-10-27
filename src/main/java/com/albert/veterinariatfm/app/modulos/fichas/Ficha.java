package com.albert.veterinariatfm.app.modulos.fichas;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "fichas")
@Data
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

    @Column (name = "id_raza")
    Long idRaza;

    @Column (name = "id_cliente")
    Long idCliente;

}
