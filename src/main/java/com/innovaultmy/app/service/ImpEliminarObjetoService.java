package com.innovaultmy.app.service;

import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.repositories.EliminarObjetosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ImpEliminarObjetoService implements EliminarObjetoService{

    private final EliminarObjetosRepository eliminarObjetosRepository;

    public ImpEliminarObjetoService(EliminarObjetosRepository eliminarObjetosRepository){
        this.eliminarObjetosRepository = eliminarObjetosRepository;
    }
    @Override
    @Transactional
    public void add(ObjetosEliminados objetosEliminados) {
        objetosEliminados.setFechaEliminacion(new Date());
        eliminarObjetosRepository.save(objetosEliminados);


    }

    @Override
    @Transactional(readOnly = true)
    public Page<ObjetosEliminados> listarEliminados(Pageable pageable) {
        return eliminarObjetosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public ObjetosEliminados buscarPorId(Integer id) {
        return eliminarObjetosRepository.findById(id).orElse(null);
    }
}
