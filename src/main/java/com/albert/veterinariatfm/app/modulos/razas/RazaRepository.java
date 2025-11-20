package com.albert.veterinariatfm.app.modulos.razas;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Funcion que comunica la base de dato de Raza mediantes Jpa y los endpoint del backend
 */
public interface RazaRepository extends JpaRepository <Raza, Long> {

}
