package com.innovaultmy.app.service;

import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.repositories.ActualizarObjetosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ImpActualizarObjetoService implements ActualizarObjetoService {
    private final ActualizarObjetosRepository actualizarObjetosRepository;

    public ImpActualizarObjetoService(ActualizarObjetosRepository actualizarObjetosRepository){
        this.actualizarObjetosRepository = actualizarObjetosRepository;
    }
    @Override
    @Transactional
    public void add(ObjetosActualizados objetosActualizados) {
        objetosActualizados.setFechaActualizacion(new Date());
        actualizarObjetosRepository.save(objetosActualizados);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ObjetosActualizados> listarActualizados(Pageable pageable) {
        return actualizarObjetosRepository.findAll(pageable);
    }
    @Override
    @Transactional(readOnly = true)
    public ObjetosActualizados buscarPorId(Integer id) {
        return actualizarObjetosRepository.findById(id).orElse(null);
    }
}
