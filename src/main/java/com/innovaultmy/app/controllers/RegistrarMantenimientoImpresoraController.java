package com.innovaultmy.app.controllers;

import com.innovaultmy.app.models.ImpresoraModel;
import com.innovaultmy.app.models.MantenimientoImpresora;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.repositories.registros.MantenimientoImpresoraRepository;
import com.innovaultmy.app.service.impresora.ImpresoraService;
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
public class RegistrarMantenimientoImpresoraController {
    @Autowired
    private final ImpresoraService impresoraService;

    private final MantenimientoImpresoraRepository mantenimientoImpresoraRepository;
    public RegistrarMantenimientoImpresoraController(ImpresoraService impresoraService, MantenimientoImpresoraRepository mantenimientoImpresoraRepository) {
        this.mantenimientoImpresoraRepository = mantenimientoImpresoraRepository;
        this.impresoraService = impresoraService;
    }

    @GetMapping("/HistorialMantenimientos")
    public ModelAndView MantenimientosImpresoras(@PageableDefault(sort="fechaMantenimiento", direction = Sort.Direction.DESC, size = 20) Pageable pageable){
        Page<MantenimientoImpresora> mantenimiento = mantenimientoImpresoraRepository.findAll(pageable);
        return new ModelAndView("/AdminObjetos/historial_mantenimientos_impresoras").addObject("mantenimiento",mantenimiento);
    }

    @GetMapping("/RegistrarMantenimientoImpresora")
    public ModelAndView AdminMantenimientoImpresora()
    {
        List<ImpresoraModel> impresora = impresoraService.listaImpresoras();
        MantenimientoImpresora mantenimiento = new MantenimientoImpresora();
        return new ModelAndView("AdminObjetos/RegistrarMantenimientoImpresora")
                .addObject("impresora", impresora)
                .addObject("mantenimiento", mantenimiento);
    }
    @PostMapping("/RegistrarMantenimientoImpresora")
    public ModelAndView registrarMantenimiento(@Validated MantenimientoImpresora mantenimientoImpresora, BindingResult bindingResult, HttpSession session, @RequestParam("numeroImpresora") Integer numeroImpresora)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/RegistrarMantenimientoImpresora");
        }
        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario");
        if(usuarioModel != null)
        {
            int usuarioId = usuarioModel.getId();
            mantenimientoImpresora.setUsuario(usuarioId);
            mantenimientoImpresora.setImpresora(numeroImpresora);
            mantenimientoImpresora.setFechaMantenimiento(new Date());
            mantenimientoImpresoraRepository.save(mantenimientoImpresora);
            return new ModelAndView("redirect:/AdminObjetos/HistorialMantenimientos");

        }
        else
        {
            return new ModelAndView("redirect:/session/Loguear");
        }
    }

}
