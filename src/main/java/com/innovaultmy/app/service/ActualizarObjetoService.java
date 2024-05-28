package com.innovaultmy.app.service;

import com.innovaultmy.app.models.ObjetosActualizados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ActualizarObjetoService {
    void add(ObjetosActualizados objetosActualizados);
    Page<ObjetosActualizados> listarActualizados(Pageable pageable);

    ObjetosActualizados buscarPorId(Integer id);
}
