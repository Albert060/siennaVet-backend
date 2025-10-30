package com.albert.veterinariatfm.app.modulos.jaulas;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Funcion que comunica la base de dato de Jaulas mediantes Jpa y los endpoint del backend.
 */
public interface JaulaRepository extends JpaRepository <Jaula, Long> {
}
