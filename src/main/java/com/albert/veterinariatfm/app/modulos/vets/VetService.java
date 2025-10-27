package com.albert.veterinariatfm.app.modulos.vets;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VetService {
    @Autowired
    VetRepository vetRepository;

    /**
     * Función encargada de obtener todos los veterinarios sin filtros
     * @return List de Vet
     */
    @Transactional
    public List<Vet> obtenerVeterinarios (){
        return vetRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional
    public Vet obtenerPorId (Long id){
        return vetRepository.findById(id).get();
    }


    @Transactional
    public Vet crearVeterinarios (Vet nuevoVeterinario){
        return vetRepository.save(nuevoVeterinario);
    }

    @Transactional
    public Vet actualizarVeterinarios (Vet nuevoVeterinario){

        return vetRepository.save(nuevoVeterinario);

    }
    @Transactional
    public void borrarVeterinario (Long id){

        vetRepository.deleteById(id);
    }


}
