package com.albert.veterinariatfm.app.modulos.contactos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/api/contactos")
public class ContactoController {
    /**
     * se instancia la funcion ContactoService.
     */
    @Autowired
    ContactoService contactoService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de mensajes mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Contacto> mostrarContactos (){
        return contactoService.obtenerContactos();
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de un mensaje mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Contacto mostrarPorId (@PathVariable Long id ){
        return contactoService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear un mensaje.
     * @param nuevoContacto
     * @return
     */
    @PostMapping
    public Contacto crearContacto (@RequestBody Contacto nuevoContacto){
        return contactoService.crearContacto(nuevoContacto);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de un mensaje mediante la anotacion
     * @PutMapping y delegando al contactoService la modificación.
     * @param actualizarcontacto
     * @return
     */
    @PutMapping
    public Contacto actualizarcontacto (@RequestBody Contacto actualizarcontacto){
        return contactoService.actualizarContacto(actualizarcontacto);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de un mensaje mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        contactoService.borrarcontacto(id);
    }
}
