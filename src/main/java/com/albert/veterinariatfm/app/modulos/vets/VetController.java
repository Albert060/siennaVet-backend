package com.albert.veterinariatfm.app.modulos.vets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VetController {

    @Autowired
    VetService vetService;

    @GetMapping
    public List<Vet> mostrarVeterinarios (){

        return vetService.obtenerVeterinarios();

    }

    @GetMapping("/{id}")
    public Vet mostrarPorId (@PathVariable Long id ){
        return vetService.obtenerPorId(id);

    }

    @PostMapping
    public Vet crearVeterinario (@RequestBody Vet nuevoVeterinario){

        return vetService.crearVeterinarios(nuevoVeterinario);
    }

    @PutMapping
    public Vet actualizarVeterinario (@RequestBody Vet actualizarVeterinario){

        return vetService.actualizarVeterinarios(actualizarVeterinario);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
         vetService.borrarVeterinario(id);

    }

}
