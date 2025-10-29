package com.albert.veterinariatfm.app.modulos.vets;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Funcion que comunica la base de dato mediantes Jpa y los endpoint del backend
 */
public interface VetRepository extends JpaRepository<Vet, Long> {

        Vet findFirstByEmail(String email);

}