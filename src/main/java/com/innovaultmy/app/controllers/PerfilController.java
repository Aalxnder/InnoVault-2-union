package com.innovaultmy.app.controllers;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/Usuario")
public class PerfilController{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/VerObjetos")
    public ModelAndView VerAdminObjetos()
    {
        return new ModelAndView("paginas/VerObjetos");
    }

    @GetMapping("/Perfil")
    public ModelAndView VerPerfil() {
        return new ModelAndView("paginas/Perfil");
    }
    @Transactional
    @PostMapping("/Perfil")
    public ModelAndView guardarFotoDePerfil(@RequestParam("fotoPerfil") MultipartFile file, @RequestParam("correo") String correo, HttpSession session) {
        try {
            UsuarioModel usuario = usuarioRepository.findByCorreo(correo);
            if (usuario != null && !file.isEmpty()) {
                usuario.setFotoPerfil(file.getBytes());
                usuarioRepository.save(usuario);
                String imagenBase64 = Base64.encodeBase64String(usuario.getFotoPerfil());
                session.setAttribute("imagenBase64", imagenBase64);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/Usuario/Perfil");
    }
    @Transactional
    @PostMapping("/CambiarTelefono")
    public ModelAndView cambiarTelefono(@RequestParam("telefono") String telefono, @RequestParam("correo") String correo, HttpSession session){
        UsuarioModel usuario = usuarioRepository.findByCorreo(correo);
        usuario.setTelefono(telefono);
        usuarioRepository.save(usuario);
        session.setAttribute("usuario", usuario);

        return new ModelAndView("redirect:/Usuario/Perfil");
    }
}
