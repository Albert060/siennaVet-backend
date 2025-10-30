package com.albert.veterinariatfm.app.modulos.vets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de veterinario.
 */
@RestController
@RequestMapping("/api/veterinarios")
public class VetController {

    /**
     * se instancia la funcion VetService.
     */
    @Autowired
    VetService vetService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de veterinario mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Vet> mostrarVeterinarios (){
        return vetService.obtenerVeterinarios();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de un veterinario mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Vet mostrarPorId (@PathVariable Long id ){
        return vetService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear un veterinario.
     * @param nuevoVeterinario
     * @return
     */
    @PostMapping
    public Vet crearVeterinario (@RequestBody Vet nuevoVeterinario){
        return vetService.crearVeterinarios(nuevoVeterinario);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de veterinario mediante la anotacion
     * @PutMapping y delegando al vetService la modificación.
     * @param actualizarVeterinario
     * @return
     */
    @PutMapping
    public Vet actualizarVeterinario (@RequestBody Vet actualizarVeterinario){
        return vetService.actualizarVeterinarios(actualizarVeterinario);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de veterinario mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
         vetService.borrarVeterinario(id);
    }
}
