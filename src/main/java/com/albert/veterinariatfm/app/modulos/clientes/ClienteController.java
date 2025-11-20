package com.albert.veterinariatfm.app.modulos.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase que controla las peticiones HTTP y el manejo del CRUD de clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    /**
     * se instancia la funcion ClienteService.
     */
    @Autowired
    ClienteService clienteService;

    /**
     * Funcion encargada en recibir la peticion HTTP de la lista de cliente mediante la anotacion
     * GetMapping y enviarsela al service para que ejecute la respuesta.
     * @return
     */
    @GetMapping
    public List<Cliente> mostrarClientes (@RequestParam int offset, @RequestParam int limit){
        return clienteService.obtenerClientes(offset, limit);
    }

    /**
     * Funcion encargada en filtrar la peticion HTTP de un cliente mediante la anotacion
     * GetMapping, y el parametro id, y enviarsela al service para que ejecute la respuesta.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cliente mostrarPorId (@PathVariable Long id ){
        return clienteService.obtenerPorId(id);
    }

    /**
     * Funcion encargada en gestionar los datos enviados por el cuerpo del formulario para ser tratado
     * por el service mediantes las anotaciones de @PostMapping y @RequestBody para crear un cliente.
     * @param nuevoCliente
     * @return
     */
    @PostMapping
    public Cliente crearCliente (@RequestBody Cliente nuevoCliente){
        return clienteService.crearCliente(nuevoCliente);
    }

    /**
     * funcion encargada de gestionar una actualizacion de un registro de cliente mediante la anotacion
     * @PutMapping y delegando al clienteService la modificación.
     * @param actualizarCliente
     * @return
     */
    @PutMapping
    public Cliente actualizarCliente (@RequestBody Cliente actualizarCliente){
        return clienteService.actualizarCliente(actualizarCliente);
    }

    /**
     * Funcion encargada de gestionar la eliminacion de un registro de cliente mediante
     * la anotacion @DeleteMapping mediante su parametro id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        clienteService.borrarCliente(id);
    }
}
