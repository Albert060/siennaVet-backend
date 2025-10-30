package com.albert.veterinariatfm.app.modulos.razas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de raza.
 */
@RestController
@RequestMapping("/api/razas")
public class RazaController {

    /**
     * se instancia la funcion RazaService
     */
    @Autowired
    RazaService razaService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de Raza mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Raza> mostrarRaza (){
        return razaService.obtenerRaza();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de un Raza mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Raza mostrarPorId (@PathVariable Long id ){
        return razaService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear una Raza.
     * @param nuevaRaza
     * @return
     */
    @PostMapping
    public Raza crearRaza (@RequestBody Raza nuevaRaza){
        return razaService.crearRaza(nuevaRaza);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de Raza mediante la anotacion
     * @PutMapping y delegando al RazaService la modificación.
     * @param actualizarRaza
     * @return
     */
    @PutMapping
    public Raza actualizarRaza (@RequestBody Raza actualizarRaza){
        return razaService.actualizarRaza(actualizarRaza);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de Raza mediante
     * la anotacion @DeleteMapping mediante su parametro id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        razaService.borrarRaza(id);
    }
}
