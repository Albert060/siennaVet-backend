package com.albert.veterinariatfm.app.modulos.fichas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Clase donde se va a manejar toda la logica de fichas, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class FichaService {
    /**
     * Se instancia la funcion fichaRepository.
     */
    @Autowired
    FichaRepository fichaRepository;

    /**
     * Función encargada de obtener todos las Fichas sin filtros mediante una lista.
     * @return lista fichas
     */
    @Transactional
    public List<FichaDTO> obtenerFichas (int offset, int limit) {
        Page<FichaDTO> listaFichaPage = fichaRepository.findAllConRaza(PageRequest.of(offset, limit));

        return listaFichaPage.getContent();
    }

    /**
     * Funcion encargada de obtener la ficha con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public Ficha obtenerPorId (Long id ){
        return fichaRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear una nueva ficha.
     * @param nuevaFicha
     * @return
     */
    @Transactional
    public Ficha crearFicha (Ficha nuevaFicha){
        return fichaRepository.save(nuevaFicha);
    }

    /**
     * Funcion encargada de actualizar los datos de las fichas.
     * @param nuevaFicha
     * @return
     */
    @Transactional
    public Ficha actualizarFicha (FichaDTO nuevaFicha){
        return fichaRepository.save(FichaDTO.mapearDtoAEntidad(nuevaFicha));
    }

    /**
     * Funcion encargada de borrar un registro de ficha mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarFicha (Long id){
        fichaRepository.deleteById(id);
    }

}
