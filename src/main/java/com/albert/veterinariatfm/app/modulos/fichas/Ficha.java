package com.albert.veterinariatfm.app.modulos.fichas;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase donde se van a gestionar los parametros (Variable) de fichas que se van a solicitar para los diferentes
 * registro y comunicacion con la base de dato.
 */
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
