package com.innovaultmy.app.service.impresora;

import com.innovaultmy.app.models.ImpresoraModel;
import com.innovaultmy.app.repositories.registros.ImpresoraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ImpImpresoraService implements ImpresoraService{

    private final ImpresoraRepository impresoraRepository;
    public ImpImpresoraService(ImpresoraRepository impresoraRepository) {
        this.impresoraRepository = impresoraRepository;
    }

    @Override
    @Transactional
    public void registrarNuevoImpresora(ImpresoraModel impresoraModel) {
        impresoraModel.setEstatus("Activa");
        impresoraModel.setFechaRegistro(new Date());
        impresoraRepository.save(impresoraModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImpresoraModel> listaImpresoras(Pageable pageable) {
        return impresoraRepository.findAll(pageable);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ImpresoraModel> listaImpresoras() {
        return impresoraRepository.findAll();
    }

    @Override
    @Transactional
    public void borrar(ImpresoraModel impresoraModel) {
        impresoraRepository.delete(impresoraModel);
    }

    @Override
    @Transactional(readOnly = true)
    public ImpresoraModel buscarPorId(Integer id) {
        return impresoraRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarImpresora(ImpresoraModel impresoraModel) {
        impresoraModel.setFechaRegistro(new Date());
        impresoraRepository.save(impresoraModel);
    }
}