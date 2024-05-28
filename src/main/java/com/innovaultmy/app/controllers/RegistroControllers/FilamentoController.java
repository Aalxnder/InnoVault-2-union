package com.innovaultmy.app.controllers.RegistroControllers;


// Para guardar los registros cuando se actualizar
import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.service.ActualizarObjetoService;

// Para guardar los registros cuando se eliminan
import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.service.EliminarObjetoService;

import com.innovaultmy.app.models.FilamentoModel;
import com.innovaultmy.app.service.filamento.FilamentoService;
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

@Controller
@RequestMapping("/filamentos")
public class FilamentoController {

    @Autowired
    private final FilamentoService filamentoService;
    @Autowired
    private final ActualizarObjetoService actualizarObjetoService;
    @Autowired
    private final EliminarObjetoService eliminarObjetoService;
    public FilamentoController(FilamentoService filamentoService, ActualizarObjetoService actualizarObjetoService, EliminarObjetoService eliminarObjetoService) {
        this.filamentoService        = filamentoService;
        this.actualizarObjetoService = actualizarObjetoService;
        this.eliminarObjetoService   = eliminarObjetoService;
    }

    @GetMapping("/RegistrarFilamento")
    public ModelAndView Mostrarregistrar() {
        return new ModelAndView("AdminObjetos/registrar_Filamento")
                .addObject("filamento", new FilamentoModel());
    }
    @PostMapping("/RegistrarFilamento")
    public ModelAndView registrarObjeto(@Validated FilamentoModel filamento, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/filamentos/RegistrarFilamento")
                    .addObject("filamento", new FilamentoModel());
        }
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if(usuario != null)
        {
            int usuarioId = usuario.getId();
            filamento.setIdRegistro(usuarioId);
            filamentoService.registrarNuevoFilamento(filamento);
            return new ModelAndView("redirect:/filamentos/Indexfilamento");
        }
        else
        {
            return new ModelAndView("redirect:/session/Loguear");
        }
    }
    @GetMapping("/Indexfilamento")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort="nombre",size = 20) Pageable pageable) {
        Page<FilamentoModel> filamentos = filamentoService.listaFilamentos(pageable);
        return new ModelAndView("AdminObjetos/index_filamentos")
                .addObject("filamento",filamentos);
    }

    @PostMapping("/EditarObjeto")
    public ModelAndView editarObjeto(@RequestParam("id") Integer user,
                                     @RequestParam("idObjeto") Integer id,
                                     @RequestParam("nombreObjeto") String nombre,
                                     @RequestParam("TipoFilamento") String tipoDeFilamento,
                                     @RequestParam("CantidadFilamento") int cantidad,
                                     @RequestParam("ColorFilamento") String color,
                                     @RequestParam("notas") String notas) {

        FilamentoModel filamento = filamentoService.buscarPorId(id);

        if (filamento != null) {
            filamento.setNombre(nombre);
            filamento.setTipoDeFilamento(tipoDeFilamento);
            filamento.setCantidad(cantidad);
            filamento.setColor(color);
            filamento.setNotas(notas);

            filamentoService.actualizarFilamento(filamento);

            ObjetosActualizados ActObj = new ObjetosActualizados(id, nombre, "Filamento", user, notas);
            actualizarObjetoService.add(ActObj);
        }
        return new ModelAndView("redirect:/filamentos/Indexfilamento");
    }
    @PostMapping("/EliminarObjeto")
    public ModelAndView eliminarObjeto(@RequestParam("id") Integer user,
                                       @RequestParam("idObjeto") Integer id){

        FilamentoModel filamento = filamentoService.buscarPorId(id);

        if (filamento != null) {
            ObjetosEliminados ObjElm = new ObjetosEliminados(filamento.getId(),filamento.getNombre(), "Filamento", user);
            filamentoService.borrar(filamento);
            eliminarObjetoService.add(ObjElm);
        }
        return new ModelAndView("redirect:/filamentos/Indexfilamento");
    }
}
