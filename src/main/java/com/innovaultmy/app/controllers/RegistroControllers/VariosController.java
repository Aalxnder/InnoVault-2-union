package com.innovaultmy.app.controllers.RegistroControllers;

// Para guardar los registros cuando se actualizar
import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.service.ActualizarObjetoService;

// Para guardar los registros cuando se eliminan
import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.service.EliminarObjetoService;

import com.innovaultmy.app.models.VariosModel;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.service.varios.VariosService;
import jakarta.servlet.http.HttpSession;
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

import java.util.Date;

@Controller
@RequestMapping("/varios")
public class VariosController {

    private final VariosService variosService;

    @Autowired
    private final ActualizarObjetoService actualizarObjetoService;
    @Autowired
    private final EliminarObjetoService eliminarObjetoService;

    public VariosController(VariosService variosService, ActualizarObjetoService actualizarObjetoService, EliminarObjetoService eliminarObjetoService) {
        this.variosService = variosService;
        this.actualizarObjetoService = actualizarObjetoService;
        this.eliminarObjetoService = eliminarObjetoService;
    }
    @GetMapping("/RegistrarVarios")
    public ModelAndView Mostrarregistrar()
    {
        return new ModelAndView("AdminObjetos/registrar_Varios")
                .addObject("Miscelanea", new VariosModel());
    }
    @PostMapping("/RegistrarVarios")
    public ModelAndView registrarObjeto(@Validated VariosModel Miscelanea, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("AdminObjetos/registrar_Varios")
                    .addObject("Miscelanea", new VariosModel());
        }
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            int usuarioId = usuario.getId();
            Miscelanea.setIdRegistro(usuarioId);
            variosService.registrarNuevoVarios(Miscelanea);
            return new ModelAndView("redirect:/varios/IndexVarios");
        }
        else
        {
            return new ModelAndView("redirect:/session/Loguear");
        }
    }

    @GetMapping("/IndexVarios")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort="nombre",size = 20) Pageable pageable) {
        Page<VariosModel> Miscelaneas = variosService.listaVarios(pageable);
        return new ModelAndView("AdminObjetos/index_varios")
                .addObject("Miscelanea",Miscelaneas);
    }

    @PostMapping("/EditarVarios")
    public  ModelAndView EditarVarios(@RequestParam("id") Integer user,
                                      @RequestParam("idObjeto") Integer id,
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("cantidad") int cantidad,
                                      @RequestParam("categoria") String categoria,
                                      @RequestParam("descripcion") String descripcion) {

        VariosModel Varios  = variosService.buscarPorId(id);
        if (Varios != null) {
            Varios.setNombre(nombre);
            Varios.setCantidad(cantidad);
            Varios.setCategoria(categoria);
            Varios.setDescripcion(descripcion);

            variosService.actualizarVarios(Varios);

            ObjetosActualizados ObjAct = new ObjetosActualizados(id,nombre,"Varios", user, descripcion);
            actualizarObjetoService.add(ObjAct);
        }
        return new ModelAndView("redirect:/varios/IndexVarios");
    }
    @PostMapping("/EliminarVarios")
    public ModelAndView eliminarVario(@RequestParam("id") Integer user,
                                      @RequestParam("idObjeto") Integer id){
        VariosModel VariosM = variosService.buscarPorId(id);

        if (VariosM != null){
            ObjetosEliminados ObjElm = new ObjetosEliminados(id, VariosM.getNombre(), "Varios", user);
            variosService.borrar(VariosM);
            eliminarObjetoService.add(ObjElm);
        }
        return new ModelAndView("redirect:/varios/IndexVarios");
    }
}
