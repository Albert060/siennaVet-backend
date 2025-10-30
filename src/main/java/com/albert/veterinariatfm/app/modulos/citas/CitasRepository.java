package com.albert.veterinariatfm.app.modulos.citas;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Funcion que comunica la base de dato de citas mediantes Jpa y los endpoint del backend.
 */
public interface CitasRepository extends JpaRepository <Cita, Long>{
}
