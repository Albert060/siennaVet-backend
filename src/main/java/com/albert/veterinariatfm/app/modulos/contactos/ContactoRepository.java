package com.albert.veterinariatfm.app.modulos.contactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactoRepository extends CrudRepository<Contacto, Long> {
    List<Contacto> findAllByOrderByIdContactoDesc();
}
