package com.albert.veterinariatfm.app.modulos.fichas;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FichaService {
    @Autowired

    FichaRepository fichaRepository;
    @Transactional
    public List<Ficha> obtenerFichas (){

        return fichaRepository.findAll();

    }
    @Transactional
    public Ficha obtenerPorId (Long id ){
        return fichaRepository.findById(id).get();

    }
    @Transactional
    public Ficha crearFicha (Ficha nuevaFicha){

        return fichaRepository.save(nuevaFicha);

    }
    @Transactional
    public Ficha actualizarFicha (Ficha nuevaFicha){

        return fichaRepository.save(nuevaFicha);

    }
    @Transactional
    public void borrarFicha (Long id){

        fichaRepository.deleteById(id);
    }

}
