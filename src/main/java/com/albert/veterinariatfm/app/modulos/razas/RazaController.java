package com.albert.veterinariatfm.app.modulos.razas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/razas")
public class RazaController {

    @Autowired
    RazaService razaService;

    @GetMapping
    public List<Raza> mostrarRaza (){
        return razaService.obtenerRaza();
    }

    @GetMapping("/{id}")
    public Raza mostrarPorId (@PathVariable Long id ){
        return razaService.obtenerPorId(id);
    }

    @PostMapping
    public Raza crearRaza (@RequestBody Raza nuevaRaza){
        return razaService.crearRaza(nuevaRaza);
    }

    @PutMapping
    public Raza actualizarRaza (@RequestBody Raza actualizarRaza){
        return razaService.actualizarRaza(actualizarRaza);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        razaService.borrarRaza(id);
    }
}
