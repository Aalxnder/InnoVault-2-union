package com.innovaultmy.app.service.varios;

import com.innovaultmy.app.models.VariosModel;
import com.innovaultmy.app.repositories.registros.VariosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ImpVariosService implements VariosService {
    private final VariosRepository variosRepository;

    public ImpVariosService(VariosRepository variosRepository) {
        this.variosRepository = variosRepository;
    }


    @Override
    @Transactional
    public void registrarNuevoVarios(VariosModel variosModel) {
        variosModel.setFechaRegistro(new Date());
        variosRepository.save(variosModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<VariosModel> listaVarios(Pageable pageable) {
        return variosRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void borrar (VariosModel variosModel) {
        variosRepository.delete(variosModel);
    }

    @Override
    @Transactional(readOnly = true)
    public VariosModel buscarPorId(Integer id) {
        return variosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarVarios(VariosModel variosModel) {
        variosModel.setFechaEdicion(new Date());
        variosRepository.save(variosModel);
    }

}
