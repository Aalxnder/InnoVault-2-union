package com.innovaultmy.app.service.impresora;

import com.innovaultmy.app.models.ImpresoraModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImpresoraService {
    void registrarNuevoImpresora(ImpresoraModel impresoraModel);
    Page<ImpresoraModel> listaImpresoras(Pageable pageable);
    List<ImpresoraModel> listaImpresoras();

    void borrar (ImpresoraModel impresoraModel);
    ImpresoraModel buscarPorId(Integer id);

    void actualizarImpresora(ImpresoraModel impresoraModel);
}
