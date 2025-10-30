package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de fichaActualizacion.
 */
@RestController
@RequestMapping ("/api/fichaActualizadas")
public class FichaActualizacionController {

    /**
     * se instancia la funcion FichaActualizacionService.
     */
    @Autowired
    FichaActualizacionService fichaActualizacionService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de fichaActualizacion mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<FichaActualizacion> mostrarFichasActualizadas (){
        return fichaActualizacionService.obtenerFichaActualizacion();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de una fichaActualizacion mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public FichaActualizacion mostrarPorId (@PathVariable Long id ){
        return fichaActualizacionService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear un fichaActualizacion.
     * @param nuevaFichaActualizada
     * @return
     */
    @PostMapping
    public FichaActualizacion crearFichaActualizada (@RequestBody FichaActualizacion nuevaFichaActualizada){
        return fichaActualizacionService.crearNuevaFicha(nuevaFichaActualizada);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de fichaActualizacion mediante la anotacion
     * @PutMapping y delegando al vetService la modificación.
     * @param actualizarFicha
     * @return
     */
    @PutMapping
    public FichaActualizacion actualizarFicha (@RequestBody FichaActualizacion actualizarFicha){
        return fichaActualizacionService.actualizarFicha(actualizarFicha);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de fichaActualizacion mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        fichaActualizacionService.borrarFichaActualizada(id);
    }
}
