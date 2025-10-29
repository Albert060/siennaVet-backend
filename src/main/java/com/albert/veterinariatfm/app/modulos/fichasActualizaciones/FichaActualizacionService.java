package com.albert.veterinariatfm.app.modulos.fichasActualizaciones;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FichaActualizacionService {

    @Autowired
    FichaActualizacionRepository fichaActualizacionRepository;

    @Transactional
    public List<FichaActualizacion> obtenerFichaActualizacion (){
        return fichaActualizacionRepository.findAll();
    }

    @Transactional
    public FichaActualizacion obtenerPorId (Long id ){
        return fichaActualizacionRepository.findById(id).get();
    }

    @Transactional
    public FichaActualizacion crearNuevaFicha (FichaActualizacion nuevaFichaActualizada){
        return fichaActualizacionRepository.save(nuevaFichaActualizada);
    }

    @Transactional
    public FichaActualizacion actualizarFicha (FichaActualizacion nuevaFichaActualizada){
        return fichaActualizacionRepository.save(nuevaFichaActualizada);
    }

    @Transactional
    public void borrarFichaActualizada (Long id){
        fichaActualizacionRepository.deleteById(id);
    }
}
