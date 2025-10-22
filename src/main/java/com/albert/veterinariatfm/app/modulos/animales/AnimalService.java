package com.albert.veterinariatfm.app.modulos.animales;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    @Transactional
    public List<Animal> obtenerAnimal (){

        return animalRepository.findAll();

    }
    @Transactional
    public Animal obtenerPorId (Long id ){
        return animalRepository.findById(id).get();

    }
    @Transactional
    public Animal crearAnimal (Animal nuevoAnimal){

        return animalRepository.save(nuevoAnimal);

    }
    @Transactional
    public Animal actualizarAnimal (Animal nuevoAnimal){

        return animalRepository.save(nuevoAnimal);

    }
    @Transactional
    public void borrarAnimal (Long id){

        animalRepository.deleteById(id);
    }
}
