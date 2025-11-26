package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase donde se va a manejar toda la logica de fichaActualizacion, los endpoint tratados y donde se van a gestionar
 * los datos.
 */
@Service
public class FichaActualizacionService {

    /**
     * Se instancia la funcion FichaActualizacionRepository.
     */
    @Autowired
    FichaActualizacionRepository fichaActualizacionRepository;

    /**
     * Función encargada de obtener todos los fichaActualizacion sin filtros mediante una lista.
     * @return lista de fichasActualizada
     */
    @Transactional
    public List<FichaActualizacion> obtenerFichaActualizacion (int offset, int limit){
        Page<FichaActualizacion> listaFichaActualizacionPage = fichaActualizacionRepository.findAll(PageRequest.of(offset, limit));

        return listaFichaActualizacionPage.getContent();
    }

    /**
     * Funcion encargada de obtener a las fichasActualizacion con filtro del parametro id.
     * @param id
     * @return
     */
    @Transactional
    public FichaActualizacion obtenerPorId (Long id ){
        return fichaActualizacionRepository.findById(id).get();
    }

    /**
     * Funcion encargada de crear una nueva fichaActualizacion.
     * @param nuevaFichaActualizada
     * @return
     */
    @Transactional
    public FichaActualizacion crearNuevaFicha (FichaActualizacion nuevaFichaActualizada){
        return fichaActualizacionRepository.save(nuevaFichaActualizada);
    }

    /**
     * Funcion encargada de actualizar los datos de las fichaActualizacion.
     * @param nuevaFichaActualizada
     * @return
     */
    @Transactional
    public FichaActualizacion actualizarFicha (FichaActualizacion nuevaFichaActualizada){
        return fichaActualizacionRepository.save(nuevaFichaActualizada);
    }

    /**
     * Funcion encargada de borrar un registro de fichaActualizacion mediante su parametro.
     * @param id
     */
    @Transactional
    public void borrarFichaActualizada (Long id){
        fichaActualizacionRepository.deleteById(id);
    }
}
