package com.albert.veterinariatfm.app.modulos.fichas;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FichaDTO {

    Integer idFicha;

    String nombre;

    String sexo;

    String edad;

    String peso;

    String chip;

    String raza;
}
