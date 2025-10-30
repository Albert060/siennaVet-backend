package com.albert.veterinariatfm.app.modulos.vets;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de veterinario, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class VetService {

    /**
     * Se instancia la funcion VetRepository.
     */
    @Autowired
    VetRepository vetRepository;

    /**
     * Función encargada de obtener todos los veterinarios sin filtros mediante una lista.
     * @return List de Vet
     */
    @Transactional
    public List<Vet> obtenerVeterinarios (){
        return vetRepository.findAll();
    }

    /**
     * Funcion encargada de obtener a los Veterinarios con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Vet obtenerPorId (Long id){
        return vetRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear un nuevo Veterinario.
     * @param nuevoVeterinario
     * @return
     */
    @Transactional
    public Vet crearVeterinarios (Vet nuevoVeterinario){
        return vetRepository.save(nuevoVeterinario);
    }

    /**
     * Funcion encargada de actualizar los datos de los Veterinarios.
     * @param nuevoVeterinario
     * @return
     */
    @Transactional
    public Vet actualizarVeterinarios (Vet nuevoVeterinario){
        return vetRepository.save(nuevoVeterinario);
    }

    /**
     * Funcion encargada de borrar un registro de Veterinario mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarVeterinario (Long id){
        vetRepository.deleteById(id);
    }
}
