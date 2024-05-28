package com.innovaultmy.app.service.filamento;


import com.innovaultmy.app.models.FilamentoModel;
import com.innovaultmy.app.repositories.registros.FilamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ImpFilamentoService implements FilamentoService {

    private final FilamentoRepository filamentoRepository;
    public ImpFilamentoService(FilamentoRepository filamentoRepository) {
        this.filamentoRepository = filamentoRepository;
    }

    @Override
    @Transactional
    public void registrarNuevoFilamento(FilamentoModel nuevoFilamento) {
        nuevoFilamento.setFechaRegistro(new Date());
        filamentoRepository.save(nuevoFilamento);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FilamentoModel> listaFilamentos(Pageable pageable) {
        return filamentoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void borrar(FilamentoModel filamento) {
        filamentoRepository.delete(filamento);
    }

    @Override
    @Transactional(readOnly = true)
    public FilamentoModel buscarPorId(Integer id) {
        return filamentoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarFilamento(FilamentoModel filamento) {
        filamento.setFechaEdicion(new Date());
        filamentoRepository.save(filamento);
    }
}
