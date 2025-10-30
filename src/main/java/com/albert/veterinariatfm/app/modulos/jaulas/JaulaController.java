package com.albert.veterinariatfm.app.modulos.jaulas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de Jaulas.
 */
@RestController
@RequestMapping("/api/jaulas")
public class JaulaController {

    /**
     * se instancia la funcion JaulaService.
     */
    @Autowired
    JaulaService jaulaService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de Jaulas mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Jaula> mostrarJaula() {
        return jaulaService.obtenerJaula();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de una jaula mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Jaula mostrarPorId(@PathVariable Long id) {
        return jaulaService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear una jaula.
     * @param nuevaJaula
     * @return
     */
    @PostMapping
    public Jaula crearVeterinario (@RequestBody Jaula nuevaJaula){
        return jaulaService.crearJaula(nuevaJaula);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de una jaula mediante la anotacion
     * @PutMapping y delegando al jaulaService la modificación.
     * @param actualizarJaula
     * @return
     */
    @PutMapping
    public Jaula actualizarJaula (@RequestBody Jaula actualizarJaula){
        return jaulaService.actualizarJaula(actualizarJaula);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de jaula mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        jaulaService.borrarJaula(id);
    }
}
