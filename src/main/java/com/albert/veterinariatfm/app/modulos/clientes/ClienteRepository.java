package com.albert.veterinariatfm.app.modulos.clientes;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Funcion que comunica la base de dato de cliente mediantes Jpa y los endpoint del backend.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
