package com.albert.veterinariatfm.app.modulos.citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de citas.
 */
@RestController
@RequestMapping ("/api/citas")
public class CitaController {
    /**
     * se instancia la funcion citaService.
     */
    @Autowired
    CitaService citaService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de citas mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Cita> mostrarCitas (){
        return citaService.obtenerCitas();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de una cita mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cita mostrarPorId (@PathVariable Long id ){
        return citaService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear una cita.
     * @param nuevaCita
     * @return
     */
    @PostMapping
    public Cita crearVeterinario (@RequestBody Cita nuevaCita){
        return citaService.crearCita(nuevaCita);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de citas mediante la anotacion
     *      * @PutMapping y delegando al citaService la modificación.
     * @param actualizarCita
     * @return
     */
    @PutMapping
    public Cita actualizarCita (@RequestBody Cita actualizarCita){
        return citaService.actualizarCita(actualizarCita);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de cita mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        citaService.borrarCita(id);
    }
}
