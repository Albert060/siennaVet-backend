package com.albert.veterinariatfm.app.modulos.fichas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Funcion que comunica la base de dato de fichas mediantes Jpa y los endpoint del backend.
 */
public interface FichaRepository extends JpaRepository<Ficha, Long>{

    @Query(value="select f.id_ficha, f.nombre, f.sexo, f.edad, f.peso, f.chip, r.nombre as raza, f.id_raza, f.id_cliente from fichas as f join razas as r on r.id_raza = f.id_raza", nativeQuery = true)
    Page<FichaDTO> findAllConRaza(PageRequest pageRequest);
}
