package com.albert.veterinariatfm.app.modulos.razas;

import com.albert.veterinariatfm.app.modulos.fichas.FichaDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de Raza, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class RazaService {

    /**
     * Se instancia la funcion RazaRepository.
     */
    @Autowired
    RazaRepository razaRepository;

    /**
     * Se instancia la funcion VetRepository.
     * @return list Raza
     */
    @Transactional
    public List<Raza> obtenerRaza (int offset, int limit){
        Page<Raza> listaRazaPage = razaRepository.findAll(PageRequest.of(offset, limit));

        return listaRazaPage.getContent();
    }

    /**
     * Funcion encargada de obtener a las razas con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Raza obtenerPorId (Long id ){
        return razaRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear un nuevo registro de Raza.
     * @param nuevaRaza
     * @return
     */
    @Transactional
    public Raza crearRaza (Raza nuevaRaza){
        return razaRepository.save(nuevaRaza);
    }

    /**
     * Funcion encargada de actualizar los datos de las Razas.
     * @param nuevaRaza
     * @return
     */
    @Transactional
    public Raza actualizarRaza (Raza nuevaRaza){
        return razaRepository.save(nuevaRaza);
    }

    /**
     * Funcion encargada de borrar un registro de Razas mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarRaza (Long id){
        razaRepository.deleteById(id);
    }
}
