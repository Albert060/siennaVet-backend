package com.albert.veterinariatfm.app.modulos.contactos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactoRepository extends CrudRepository<Contacto, Long> {
    Page<Contacto> findAllByOrderByIdContactoDesc(PageRequest PageRequest);
}
