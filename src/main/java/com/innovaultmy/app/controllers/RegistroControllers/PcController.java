package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.models.ComputadoraModel;
import com.innovaultmy.app.service.pc.PcService;

// Para guardar los registros cuando se actualizar
import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.service.ActualizarObjetoService;

// Para guardar los registros cuando se eliminan
import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.service.EliminarObjetoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/computadoras")
public class PcController
{
    @Autowired
    private final PcService pcService;

    @Autowired
    private final ActualizarObjetoService actualizarObjetoService;
    private final EliminarObjetoService eliminarObjetoService;

    public PcController(PcService pcService,ActualizarObjetoService actualizarObjetoService, EliminarObjetoService eliminarObjetoService) {
        this.pcService               = pcService;
        this.actualizarObjetoService = actualizarObjetoService;
        this.eliminarObjetoService   = eliminarObjetoService;
    }

    @GetMapping("/RegistrarPc")
    public ModelAndView mostrarRegistrarPc() {
        return new ModelAndView("AdminObjetos/registrar_Computadora")
                .addObject("computadora", new ComputadoraModel());
    }
    @PostMapping("/RegistrarPc")
    public ModelAndView RegistrarPc(@Validated ComputadoraModel computadoraModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/computadora/RegistrarPc");
        }
        pcService.registrarNuevaPc(computadoraModel);
        return new ModelAndView("redirect:/computadoras/IndexComputadoras");
    }
    @GetMapping("/IndexComputadoras")
    public ModelAndView mostrarIndex(@PageableDefault(sort="numeroDeCompu",size = 20) Pageable pageable)
    {
        Page<ComputadoraModel> computadora = pcService.litaComputadoras(pageable);
        return new ModelAndView("AdminObjetos/index_computadoras")
                .addObject("computadora",computadora);
    }
    @PostMapping("/EditarPc")
    public ModelAndView actualizarPc(@RequestParam("id")Integer user,
                                     @RequestParam("idObjeto")Integer id,
                                     @RequestParam("numero") Integer numeroDeCompu,
                                     @RequestParam("modelo")String modelo,
                                     @RequestParam("marca")String marca,
                                     @RequestParam("notas") String notas) {

        ComputadoraModel pc = pcService.buscarPorId(id);

        if(pc != null) {
            pc.setNumeroDeCompu(numeroDeCompu);
            pc.setModelo(modelo);
            pc.setMarca(marca);
            pc.setNotas(notas);

            pcService.actualizarPc(pc);

            ObjetosActualizados ObjAct = new ObjetosActualizados(id, numeroDeCompu.toString(), "Computadora", user, notas);
            actualizarObjetoService.add(ObjAct);
        }
        return new ModelAndView("redirect:/computadoras/IndexComputadoras");
    }
    @PostMapping("/EliminarPc")
    public ModelAndView eliminarPC(@RequestParam("id") Integer user,
                                   @RequestParam("idObjeto") Integer id) {

        ComputadoraModel pc = pcService.buscarPorId(id);

        if (pc != null) {
            ObjetosEliminados ObjElm = new ObjetosEliminados(pc.getId(), pc.getNumeroDeCompu().toString(), "Computadora", user);
            pcService.borrarPc(pc);
            eliminarObjetoService.add(ObjElm);
        }
        return new ModelAndView("redirect:/computadoras/IndexComputadoras");
    }
}
