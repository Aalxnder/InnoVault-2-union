package com.innovaultmy.app.service;

import com.innovaultmy.app.models.ObjetosEliminados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EliminarObjetoService {
    void add(ObjetosEliminados objetosEliminados);
    Page<ObjetosEliminados> listarEliminados(Pageable pageable);

    ObjetosEliminados buscarPorId(Integer id);
}
