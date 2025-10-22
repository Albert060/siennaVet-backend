package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import jakarta.persistence.*;

@Entity
@Table (name = "fichaActualizacion")

public class FichaActualizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFichaActualizacion;

    @Column (name = "comentario")
    String comentario;

    @Column (name = "fecha")
    String fecha;

    @Column (name = "esUrgencia")
    boolean esUrgencia;

    @Column (name = "idFicha")
    Long idFicha;

    @Column (name = "idVet")
    Long idVet;
}
