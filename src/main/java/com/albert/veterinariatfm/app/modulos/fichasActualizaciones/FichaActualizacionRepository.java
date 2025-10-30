package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Funcion que comunica la base de dato de fichasActualizacion mediantes Jpa y los endpoint del backend.
 */
public interface FichaActualizacionRepository extends JpaRepository <FichaActualizacion, Long> {
}
