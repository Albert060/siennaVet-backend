package com.albert.veterinariatfm.app.modulos.jaulas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jaulas")
public class JaulaController {

    @Autowired
    JaulaService jaulaService;

    @GetMapping
    public List<Jaula> mostrarJaula() {

        return jaulaService.obtenerJaula();

    }

    @GetMapping("/{id}")
    public Jaula mostrarPorId(@PathVariable Long id) {
        return jaulaService.obtenerPorId(id);

    }

    @PostMapping
    public Jaula crearVeterinario (@RequestBody Jaula nuevaJaula){

        return jaulaService.crearJaula(nuevaJaula);
    }

    @PutMapping
    public Jaula actualizarJaula (@RequestBody Jaula actualizarJaula){

        return jaulaService.actualizarJaula(actualizarJaula);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        jaulaService.borrarJaula(id);

    }
}
