package com.innovaultmy.app.controllers;

import com.innovaultmy.app.models.ComputadoraModel;
import com.innovaultmy.app.models.MantenimientoComputadora;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.repositories.registros.MantenimientoComputadoraRepository;
import com.innovaultmy.app.service.pc.PcService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/AdminObjetos")
public class RegistrarMantenimientoComputadoraController {
    @Autowired
    private final PcService pcService;
    private final MantenimientoComputadoraRepository mantenimientoComputadoraRepository;

    public RegistrarMantenimientoComputadoraController(PcService pcService, MantenimientoComputadoraRepository mantenimientoComputadoraRepository) {
        this.pcService = pcService;
        this.mantenimientoComputadoraRepository = mantenimientoComputadoraRepository;
    }

    @GetMapping("/HistorialMantenimientosComputadoras")
    public ModelAndView MantenimientosImpresoras(@PageableDefault(sort="fechaMantenimiento", direction = Sort.Direction.DESC, size = 20) Pageable pageable){
        Page<MantenimientoComputadora> mantenimiento = mantenimientoComputadoraRepository.findAll(pageable);
        return new ModelAndView("/AdminObjetos/historial_mantenimientos_computadoras").addObject("mantenimiento",mantenimiento);
    }

    @GetMapping("/RegistrarMantenimientoComputadora")
    public ModelAndView AdminMantenimientoImpresora() {
        List<ComputadoraModel> computadoras = pcService.litaComputadoras();
        MantenimientoComputadora mantenimiento = new MantenimientoComputadora();
        return new ModelAndView("AdminObjetos/RegistrarMantenimientoComputadora")
                .addObject("computadoras", computadoras)
                .addObject("mantenimiento", mantenimiento);
    }
    @PostMapping("/RegistrarMantenimientoComputadora")
    public ModelAndView registrarMantenimiento(@Validated MantenimientoComputadora mantenimientoComputadora, BindingResult bindingResult, HttpSession session, @RequestParam("numeroComputadora") Integer numeroComputadora)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/RegistrarMantenimientoComputadora");
        }
        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario");
        if(usuarioModel != null)
        {
            int usuarioId = usuarioModel.getId();
            mantenimientoComputadora.setUsuario(usuarioId);
            mantenimientoComputadora.setComputadora(numeroComputadora);
            mantenimientoComputadora.setFechaMantenimiento(new Date());
            mantenimientoComputadoraRepository.save(mantenimientoComputadora);
            return new ModelAndView("redirect:/AdminObjetos/HistorialMantenimientosComputadoras");

        }
        else
        {
            return new ModelAndView("redirect:/session/Loguear");
        }
    }

}
