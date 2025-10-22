package com.albert.veterinariatfm.app.modulos.razas;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaService {
    @Autowired

    RazaRepository razaRepository;
    @Transactional
    public List<Raza> obtenerRaza (){

        return razaRepository.findAll();

    }
    @Transactional
    public Raza obtenerPorId (Long id ){
        return razaRepository.findById(id).get();

    }
    @Transactional
    public Raza crearRaza (Raza nuevaRaza){

        return razaRepository.save(nuevaRaza);

    }
    @Transactional
    public Raza actualizarRaza (Raza nuevaRaza){

        return razaRepository.save(nuevaRaza);

    }
    @Transactional
    public void borrarRaza (Long id){

        razaRepository.deleteById(id);
    }
}
