package com.albert.veterinariatfm.app.modulos.vets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {

        Vet findFirstByEmail(String email);

}