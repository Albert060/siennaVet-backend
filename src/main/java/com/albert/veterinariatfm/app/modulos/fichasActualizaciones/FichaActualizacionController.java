package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/fichaActualizadas")

public class FichaActualizacionController {

    @Autowired
    FichaActualizacionService fichaActualizacionService;

    @GetMapping
    public List<FichaActualizacion> mostrarFichasActualizadas (){

        return fichaActualizacionService.obtenerFichaActualizacion();

    }

    @GetMapping("/{id}")
    public FichaActualizacion mostrarPorId (@PathVariable Long id ){
        return fichaActualizacionService.obtenerPorId(id);

    }

    @PostMapping
    public FichaActualizacion crearFichaActualizada (@RequestBody FichaActualizacion nuevaFichaActualizada){

        return fichaActualizacionService.crearNuevaFicha(nuevaFichaActualizada);
    }

    @PutMapping
    public FichaActualizacion actualizarFicha (@RequestBody FichaActualizacion actualizarFicha){

        return fichaActualizacionService.actualizarFicha(actualizarFicha);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        fichaActualizacionService.borrarFichaActualizada(id);

    }
}
