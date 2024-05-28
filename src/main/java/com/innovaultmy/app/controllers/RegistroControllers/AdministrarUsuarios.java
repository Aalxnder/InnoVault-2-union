package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.service.usuarios.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import com.innovaultmy.app.models.UsuarioModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
class AdministrarUsuarios{
    private final UsuarioService usuarioService;

    public AdministrarUsuarios(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/AdministrarUsuarios")
    public ModelAndView AdminUsuarios(@PageableDefault(sort="nombre",size = 20) Pageable pageable)
    {
        Page<UsuarioModel> usuarios = usuarioService.listaUsuarios(pageable);
        return new ModelAndView("paginas/AdministrarUsuarios").addObject("usuarios", usuarios);
    }
    @PostMapping("/EditarUsuario")
    public ModelAndView EditarUsuario(@RequestParam("id") Integer id,
                                      @RequestParam("idObjeto") Integer idUser,
                                      @RequestParam("permisos") String permisos){
        UsuarioModel usuario = usuarioService.buscarPorId(idUser);
        if(usuario != null){
            usuario.setPermisos(permisos);
            usuarioService.actualizarUsuario(usuario);
        }
        return new ModelAndView("redirect:/usuarios/AdministrarUsuarios");
    }
    @PostMapping("/BorrarUsuario")
    public ModelAndView EliminarUsuario(@RequestParam("idObjeto") Integer idUser){
        UsuarioModel usuario = usuarioService.buscarPorId(idUser);
        if(usuario != null){
            usuarioService.borrar(usuario);
        }
        return new ModelAndView("redirect:/usuarios/AdministrarUsuarios");
    }
}

