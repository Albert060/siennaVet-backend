package com.albert.veterinariatfm.app.modulos.jaulas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de jaulas, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class JaulaService {

    /**
     * Se instancia la funcion VetRepository.
     */
    @Autowired
    JaulaRepository jaulaRepository;

    /**
     * Función encargada de obtener todos los veterinarios sin filtros mediante una lista.
     * @return lista de jaulas
     */
    @Transactional
    public List<Jaula> obtenerJaula (){
        return jaulaRepository.findAll();
    }

    /**
     * Funcion encargada de obtener las jaulas con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Jaula obtenerPorId (Long id ){
        return jaulaRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear un nueva jaula.
     * @param nuevaJaula
     * @return
     */
    @Transactional
    public Jaula crearJaula (Jaula nuevaJaula){
        return jaulaRepository.save(nuevaJaula);
    }

    /**
     * Funcion encargada de actualizar los datos de las jaulas.
     * @param nuevaJaula
     * @return
     */
    @Transactional
    public Jaula actualizarJaula (Jaula nuevaJaula){
        return jaulaRepository.save(nuevaJaula);
    }

    /**
     * Funcion encargada de borrar un registro de jaula mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarJaula (Long id){
        jaulaRepository.deleteById(id);
    }
}
