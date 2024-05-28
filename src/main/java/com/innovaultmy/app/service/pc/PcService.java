package com.innovaultmy.app.service.pc;

import com.innovaultmy.app.models.ComputadoraModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PcService
{
    void registrarNuevaPc(ComputadoraModel pc);
    Page<ComputadoraModel> litaComputadoras (Pageable pageable);
    List<ComputadoraModel> litaComputadoras ();
    void borrarPc (ComputadoraModel pc);
    ComputadoraModel buscarPorId(Integer id);
    void actualizarPc (ComputadoraModel pc);

}
