package com.innovaultmy.app.controllers;


import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.service.usuarios.UsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sesion")
public class SesionController {
    private final UsuarioService usuarioService;

    public SesionController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/Registro")
    public ModelAndView verPaginaDeRegistro() {
        return new ModelAndView("paginas/registrar_Usuario")
                .addObject("usuario", new UsuarioModel());
    }

    @PostMapping("/Registrar")
    public ModelAndView registrar(@Validated UsuarioModel usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ModelAndView("redirect:/sesion/Registrar");
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(3, 4096, 2, usuario.getContrasenia());
        usuario.setContrasenia(hash);
        usuarioService.registrarUsuario(usuario);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/Login")
    public ModelAndView verPaginaDeLogin()
    {
        return new ModelAndView("paginas/Login");
    }

    @PostMapping("/Loguear")
    public ModelAndView login(@RequestParam("correo") String correo, @RequestParam("contrasenia") String contrasenia, HttpSession session) {
        UsuarioModel usuario = usuarioService.findByCorreo(correo); // Buscar el usuario por correo
        if (usuario != null && usuarioService.verificarCredenciales(correo, contrasenia))
        {
            session.setAttribute("usuario", usuario);
            if (usuario.getFotoPerfil() != null)
            {
                String imagenBase64 = Base64.encodeBase64String(usuario.getFotoPerfil());
                session.setAttribute("imagenBase64", imagenBase64);
            }

            return new ModelAndView ("redirect:/");
        } else {
            return new ModelAndView ("redirect:/sesion/Login");
        }
    }
    @PostMapping("/CerrarSesion")
    public ModelAndView cerrarSesion(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/sesion/Login");
    }



    @GetMapping("/Rest")
    public ModelAndView cambiar_contr() {
        return new ModelAndView("paginas/Rest");
    }
    // @PostMapping("/Cambio")
    //public ModelAndView verificar(@RequestParam("txtEmail") String email){
    //if exist_email(email){

    //}
    //else{

    //}

    //}
    @GetMapping("/verify_code")
    public ModelAndView verify_code(){
        return new ModelAndView("paginas/verify_code");
    }
}