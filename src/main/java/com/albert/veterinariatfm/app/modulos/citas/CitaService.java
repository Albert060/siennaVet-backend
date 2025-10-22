package com.albert.veterinariatfm.app.modulos.citas;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    CitasRepository citasRepository;

    public List<Cita> obtenerCitas () {

        return citasRepository.findAll();
    }
    @Transactional
    public Cita obtenerPorId (Long id ){
        return citasRepository.findById(id).get();

    }
    @Transactional
    public Cita crearCita (Cita nuevaCita){

        return citasRepository.save(nuevaCita);

    }
    @Transactional
    public Cita actualizarCita (Cita nuevaCita){

        return citasRepository.save(nuevaCita);

    }
    @Transactional
    public void borrarCita (Long id){

        citasRepository.deleteById(id);
    }
}
