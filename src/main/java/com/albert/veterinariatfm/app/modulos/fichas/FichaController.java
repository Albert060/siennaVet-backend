package com.albert.veterinariatfm.app.modulos.fichas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de fichas.
 */
@RestController
@RequestMapping ("/api/fichas")
public class FichaController {
    /**
     * se instancia la funcion FichaService.
     */
    @Autowired
    FichaService fichaService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de fichas mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<FichaDTO> mostrarFichas(@RequestParam int offset, @RequestParam int limit) {
        return fichaService.obtenerFichas(offset, limit);
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de una ficha mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Ficha mostrarPorId (@PathVariable Long id ){
        return fichaService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear una ficha.
     * @param nuevaFicha
     * @return
     */
    @PostMapping
    public Ficha crearFicha (@RequestBody Ficha nuevaFicha){
        return fichaService.crearFicha(nuevaFicha);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de ficha mediante la anotacion
     * @PutMapping y delegando al fichaService la modificación.
     * @param actualizarFicha
     * @return
     */
    @PutMapping
    public Ficha actualizarFicha (@RequestBody FichaDTO actualizarFicha){
        return fichaService.actualizarFicha(actualizarFicha);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de ficha mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        fichaService.borrarFicha(id);
    }
}
