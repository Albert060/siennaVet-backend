package com.albert.veterinariatfm.app.modulos.jaulas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JaulaService {

    @Autowired
    JaulaRepository jaulaRepository;

    @Transactional
    public List<Jaula> obtenerJaula (){
        return jaulaRepository.findAll();
    }

    @Transactional
    public Jaula obtenerPorId (Long id ){
        return jaulaRepository.findById(id).get();
    }

    @Transactional
    public Jaula crearJaula (Jaula nuevaJaula){
        return jaulaRepository.save(nuevaJaula);
    }

    @Transactional
    public Jaula actualizarJaula (Jaula nuevaJaula){
        return jaulaRepository.save(nuevaJaula);
    }

    @Transactional
    public void borrarJaula (Long id){
        jaulaRepository.deleteById(id);
    }
}
