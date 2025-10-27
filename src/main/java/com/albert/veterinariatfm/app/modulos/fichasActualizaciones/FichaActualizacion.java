package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "fichaActualizacion")
@Data
public class FichaActualizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFichaActualizacion;

    @Column (name = "comentario")
    String comentario;

    @Column (name = "fecha")
    String fecha;

    @Column (name = "es_Urgencia")
    boolean esUrgencia;

    @Column (name = "costo")
    double costo;

    @Column (name = "forma_pago")
    String formaPago;

    @Column (name = "id_ficha")
    Long idFicha;

    @Column (name = "id_vet")
    Long idVet;
}
