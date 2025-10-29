package com.albert.veterinariatfm.app.modulos.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> mostrarClientes (){
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{id}")
    public Cliente mostrarPorId (@PathVariable Long id ){
        return clienteService.obtenerPorId(id);
    }

    @PostMapping
    public Cliente crearCliente (@RequestBody Cliente nuevoCliente){
        return clienteService.crearCliente(nuevoCliente);
    }

    @PutMapping
    public Cliente actualizarCliente (@RequestBody Cliente actualizarCliente){
        return clienteService.actualizarCliente(actualizarCliente);
    }

    @DeleteMapping("/{id}")
    public void  borrarPorId (@PathVariable Long id ){
        clienteService.borrarCliente(id);
    }
}
