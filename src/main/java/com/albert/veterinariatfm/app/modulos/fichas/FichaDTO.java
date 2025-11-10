package com.albert.veterinariatfm.app.modulos.fichas;

import lombok.*;

/**
 * Clase para tratar los datos que contiene fichas junto con raza.
 */
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

    Integer idRaza;

    Integer idCliente;

    static Ficha mapearDtoAEntidad(FichaDTO dto) {
        Ficha ficha = new Ficha();
        ficha.setIdFicha(dto.getIdFicha() != null ? dto.getIdFicha().longValue() : null);
        ficha.setNombre(dto.getNombre());
        ficha.setSexo(dto.getSexo());
        ficha.setEdad(dto.getEdad());
        ficha.setPeso(dto.getPeso());
        ficha.setChip(dto.getChip());
        ficha.setIdRaza(dto.getIdRaza() != null ? dto.getIdRaza().longValue() : null);
        ficha.setIdCliente(dto.getIdCliente() != null ? dto.getIdCliente().longValue() : null);
        return ficha;
    }
}
