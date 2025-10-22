package com.albert.veterinariatfm.app.modulos.fichas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/fichas")

public class FichaController {

    @Autowired
    FichaService fichaService;

    @GetMapping
    public List<Ficha> mostrarFichas (){

        return fichaService.obtenerFichas();

    }

    @GetMapping("/{id}")
    public Ficha mostrarPorId (@PathVariable Long id ){
        return fichaService.obtenerPorId(id);

    }

    @PostMapping
    public Ficha crearFicha (@RequestBody Ficha nuevaFicha){

        return fichaService.crearFicha(nuevaFicha);
    }

    @PutMapping
    public Ficha actualizarFicha (@RequestBody Ficha actualizarFicha){

        return fichaService.actualizarFicha(actualizarFicha);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        fichaService.borrarFicha(id);

    }
}
