package com.innovaultmy.app.controllers;
import com.innovaultmy.app.models.ObjetosActualizados;
import com.innovaultmy.app.models.ObjetosEliminados;
import com.innovaultmy.app.service.ActualizarObjetoService;
import com.innovaultmy.app.service.EliminarObjetoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paginas")
public class AdministrarObjetosController {

    private final ActualizarObjetoService actualizarObjetoService;
    private final EliminarObjetoService eliminarObjetoService;

    public AdministrarObjetosController(ActualizarObjetoService actualizarObjetoService, EliminarObjetoService eliminarObjetoService) {
        this.actualizarObjetoService = actualizarObjetoService;
        this.eliminarObjetoService = eliminarObjetoService;
    }

    @GetMapping("/AdministrarObjetos")
    public ModelAndView MostrarAdminObjetos()
    {
        return new ModelAndView("paginas/AdministrarObjetos");
    }
    @GetMapping("/Actualizaciones")
    public ModelAndView Mostraractualizaciones(@PageableDefault(sort="fechaActualizacion", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        Page<ObjetosActualizados> objetoActualizado = actualizarObjetoService.listarActualizados(pageable);
        return new ModelAndView("/AdminObjetos/actualizaciones")
                .addObject("objetoActualizado", objetoActualizado);
    }
    @GetMapping("/Eliminaciones")
    public ModelAndView Mostrareliminaciones(@PageableDefault(sort="fechaEliminacion", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        Page<ObjetosEliminados> objetoEliminado = eliminarObjetoService.listarEliminados(pageable);
        return new ModelAndView("/AdminObjetos/eliminaciones")
                .addObject("objetoEliminado", objetoEliminado);
    }
}