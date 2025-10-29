package com.albert.veterinariatfm.app.modulos.citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/api/citas")
public class CitaController {

    @Autowired
    CitaService citaService;

    @GetMapping
    public List<Cita> mostrarCitas (){
        return citaService.obtenerCitas();
    }

    @GetMapping("/{id}")
    public Cita mostrarPorId (@PathVariable Long id ){
        return citaService.obtenerPorId(id);
    }

    @PostMapping
    public Cita crearVeterinario (@RequestBody Cita nuevaCita){
        return citaService.crearCita(nuevaCita);
    }

    @PutMapping
    public Cita actualizarCita (@RequestBody Cita actualizarCita){
        return citaService.actualizarCita(actualizarCita);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        citaService.borrarCita(id);
    }
}
