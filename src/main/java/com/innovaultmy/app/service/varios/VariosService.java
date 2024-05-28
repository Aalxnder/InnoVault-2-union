package com.innovaultmy.app.service.varios;

import com.innovaultmy.app.models.VariosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VariosService {
    void registrarNuevoVarios(VariosModel variosModel);
    Page<VariosModel> listaVarios(Pageable pageable);
    void borrar (VariosModel variosModel);
    VariosModel buscarPorId(Integer id);
    void actualizarVarios(VariosModel variosModel);
}


