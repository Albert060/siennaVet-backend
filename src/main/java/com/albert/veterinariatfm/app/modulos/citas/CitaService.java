package com.albert.veterinariatfm.app.modulos.citas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de citas, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class CitaService {
    /**
     * Se instancia la funcion citaRepository.
     */
    @Autowired
    CitasRepository citasRepository;

    /**
     * Función encargada de obtener todos las citas sin filtros mediante una lista.
     * @return lista de citas
     */
    @Transactional
    public List<Cita> obtenerCitas () {
        return citasRepository.findAll();
    }

    /**
     * Funcion encargada de obtener las citas con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Cita obtenerPorId (Long id ){
        return citasRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear un nueva cita.
     * @param nuevaCita
     * @return
     */
    @Transactional
    public Cita crearCita (Cita nuevaCita){
        return citasRepository.save(nuevaCita);
    }

    /**
     * Funcion encargada de actualizar los datos de las citas.
     * @param nuevaCita
     * @return
     */
    @Transactional
    public Cita actualizarCita (Cita nuevaCita){
        return citasRepository.save(nuevaCita);
    }

    /**
     * Funcion encargada de borrar un registro de cita mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarCita (Long id){
        citasRepository.deleteById(id);
    }
}
