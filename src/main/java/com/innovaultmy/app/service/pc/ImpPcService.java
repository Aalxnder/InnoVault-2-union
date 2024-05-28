package com.innovaultmy.app.service.pc;

import com.innovaultmy.app.models.ComputadoraModel;
import com.innovaultmy.app.repositories.registros.PcRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ImpPcService implements PcService
{
    private final PcRepository pcRepository;

    public ImpPcService(PcRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    @Override
    @Transactional
    public void registrarNuevaPc(ComputadoraModel pc) {
        pc.setFechaRegistro(new Date());
        pcRepository.save(pc);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ComputadoraModel> litaComputadoras(Pageable pageable) {return pcRepository.findAll(pageable);}
    @Override
    @Transactional(readOnly = true)
    public List<ComputadoraModel> litaComputadoras() {return pcRepository.findAll();}

    @Override
    @Transactional
    public void borrarPc(ComputadoraModel pc) {
        pcRepository.delete(pc);
    }

    @Override
    @Transactional(readOnly = true)
    public ComputadoraModel buscarPorId(Integer id) {
        return pcRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarPc(ComputadoraModel pc) {
        pc.setFechaEdicion(new Date());
        pcRepository.save(pc);
    }
}
