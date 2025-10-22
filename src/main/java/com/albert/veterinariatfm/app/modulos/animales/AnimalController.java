package com.albert.veterinariatfm.app.modulos.animales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/animales")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping
    public List<Animal> mostrarAnimales (){

        return animalService.obtenerAnimal();

    }

    @GetMapping("/{id}")
    public Animal mostrarPorId (@PathVariable Long id ){
        return animalService.obtenerPorId(id);

    }

    @PostMapping
    public Animal crearAnimal (@RequestBody Animal nuevoAnimal){

        return animalService.crearAnimal(nuevoAnimal);
    }

    @PutMapping
    public Animal actualizarAnimal (@RequestBody Animal actualizarAnimal){

        return animalService.actualizarAnimal(actualizarAnimal);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        animalService.borrarAnimal(id);

    }
}
