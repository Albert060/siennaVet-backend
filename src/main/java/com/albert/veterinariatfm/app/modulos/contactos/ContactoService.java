package com.albert.veterinariatfm.app.modulos.contactos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;
    /**
     * Función encargada de obtener todos las Fichas sin filtros mediante una lista.
     * @return lista fichas
     */
    @Transactional
    public List<Contacto> obtenerContactos () {
        return contactoRepository.findAll();
    }

    /**
     * Funcion encargada de obtener la ficha con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Contacto obtenerPorId (Long id ){
        return contactoRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear una nueva ficha.
     * @param nuevoContacto
     * @return
     */
    @Transactional
    public Contacto crearContacto (Contacto nuevoContacto){
        return contactoRepository.save(nuevoContacto);
    }

    /**
     * Funcion encargada de actualizar los datos de las fichas.
     * @param nuevoContacto
     * @return
     */
    @Transactional
    public Contacto actualizarContacto (Contacto nuevoContacto){
        return contactoRepository.save(nuevoContacto);
    }

    /**
     * Funcion encargada de borrar un registro de ficha mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarcontacto (Long id){
        contactoRepository.deleteById(id);
    }
}
