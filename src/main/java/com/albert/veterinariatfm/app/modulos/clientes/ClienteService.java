package com.albert.veterinariatfm.app.modulos.clientes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public List<Cliente> obtenerClientes (){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente obtenerPorId (Long id ){
        return clienteRepository.findById(id).get();
    }

    @Transactional
    public Cliente crearCliente (Cliente nuevoCliente){
        return clienteRepository.save(nuevoCliente);
    }

    @Transactional
    public Cliente actualizarCliente (Cliente nuevoCliente){
        return clienteRepository.save(nuevoCliente);
    }

    @Transactional
    public void borrarCliente (Long id){
        clienteRepository.deleteById(id);
    }
}
