package com.innovaultmy.app.controllers.RegistroControllers;

// Para guardar los registros cuando se actualizar
import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.service.ActualizarObjetoService;

// Para guardar los registros cuando se eliminan
import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.service.EliminarObjetoService;

import com.innovaultmy.app.models.ImpresoraModel;
import com.innovaultmy.app.service.impresora.ImpresoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/impresoras")
public class ImpresorasController
{
    @Autowired
    private final ImpresoraService impresoraService;
    @Autowired
    private final ActualizarObjetoService actualizarObjetoService;
    @Autowired
    private final EliminarObjetoService eliminarObjetoService;

    public ImpresorasController(ImpresoraService impresoraService, ActualizarObjetoService actualizarObjetoService, EliminarObjetoService eliminarObjetoService) {
        this.impresoraService = impresoraService;
        this.actualizarObjetoService = actualizarObjetoService;
        this.eliminarObjetoService = eliminarObjetoService;
    }
    @GetMapping("/IndexImpresoras")
    public ModelAndView verImpresoras(@PageableDefault(sort="numImpresora",size = 20) Pageable pageable)
    {
        Page<ImpresoraModel> impresoras = impresoraService.listaImpresoras(pageable);
        return new ModelAndView("AdminObjetos/index_impresoras")
                .addObject("impresoras",impresoras);
    }

    @GetMapping("/RegistrarImpresora")
    public ModelAndView mostrarRegistrarImpresora()
    {
        return new ModelAndView("AdminObjetos/registrar_Impresoras")
                .addObject("impresora", new ImpresoraModel());
    }

    @PostMapping("/RegistrarImpresora")
    public ModelAndView registrarImpresora(@Validated ImpresoraModel impresoraModel, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/registrar_Impresoras")
                    .addObject("impresora", new ImpresoraModel());
        }
        impresoraService.registrarNuevoImpresora(impresoraModel);
        return new ModelAndView("redirect:/impresoras/IndexImpresoras");
    }
    @PostMapping("/EditarImpresora")
    public  ModelAndView editarImpresora(@RequestParam("id") Integer user,
                                         @RequestParam("idObjeto")Integer idImpresora,
                                         @RequestParam("numImpresora")String numImpresora,
                                         @RequestParam("tipo") String tipo,
                                         @RequestParam("marca") String marca,
                                         @RequestParam("estatus") String estatus,
                                         @RequestParam("notas") String notas) {
        ImpresoraModel impresora = impresoraService.buscarPorId(idImpresora);
        if(impresora != null){
            impresora.setNumImpresora(numImpresora);
            impresora.setTipo(tipo);
            impresora.setMarca(marca);
            impresora.setEstatus(estatus);

            impresoraService.actualizarImpresora(impresora);

            ObjetosActualizados ObjAct = new ObjetosActualizados(idImpresora,impresora.getNumImpresora().toString() + ' ' + impresora.getTipo(), "Impresora", user, notas);
            actualizarObjetoService.add(ObjAct);
        }
        return new ModelAndView("redirect:/impresoras/IndexImpresoras");
    }

    @PostMapping("/EliminarImpresora")
    public ModelAndView eliminarPC(@RequestParam("id") Integer user,
                                   @RequestParam("idObjeto") Integer id) {

        ImpresoraModel impresora = impresoraService.buscarPorId(id);

        if (impresora != null) {
            ObjetosEliminados ObjElm = new ObjetosEliminados(impresora.getId(), impresora.getNumImpresora().toString() + " " + impresora.getTipo(), "Impresora", user);
            impresoraService.borrar(impresora);
            eliminarObjetoService.add(ObjElm);
        }
        return new ModelAndView("redirect:/impresoras/IndexImpresoras");
    }

}
