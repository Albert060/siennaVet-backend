package com.albert.veterinariatfm.app.modulos.clientes;

import com.albert.veterinariatfm.app.modulos.razas.Raza;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de clientes, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class ClienteService {
    /**
     * Se instancia la funcion ClienteRepository.
     */
    @Autowired
    ClienteRepository clienteRepository;

    /**
     * Función encargada de obtener todos los clientes sin filtros mediante una lista.
     * @return lista clientes
     */
    @Transactional
    public List<Cliente> obtenerClientes (int offset, int limit){
        Page<Cliente> listaClientePage = clienteRepository.findAll(PageRequest.of(offset, limit));
        
        return listaClientePage.getContent();
    }

    /**
     * Funcion encargada de obtener a los clientes con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Cliente obtenerPorId (Long id ){
        return clienteRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear un nuevo cliente.
     * @param nuevoCliente
     * @return
     */
    @Transactional
    public Cliente crearCliente (Cliente nuevoCliente){
        return clienteRepository.save(nuevoCliente);
    }

    /**
     * Funcion encargada de actualizar los datos de los clientes.
     * @param nuevoCliente
     * @return
     */
    @Transactional
    public Cliente actualizarCliente (Cliente nuevoCliente){
        return clienteRepository.save(nuevoCliente);
    }

    /**
     * Funcion encargada de borrar un registro de cliente mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarCliente (Long id){
        clienteRepository.deleteById(id);
    }
}
