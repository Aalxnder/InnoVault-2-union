package com.innovaultmy.app.service.filamento;

import com.innovaultmy.app.models.FilamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilamentoService {
    void registrarNuevoFilamento(FilamentoModel filamento);
    Page<FilamentoModel> listaFilamentos(Pageable pageable);

    void borrar (FilamentoModel filamento);
    FilamentoModel buscarPorId(Integer id);

    void actualizarFilamento(FilamentoModel filamento);
}
