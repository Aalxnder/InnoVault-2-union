package com.innovaultmy.app.controllers;

import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/guardar-foto-de-perfil")
    public String guardarFotoDePerfil(@RequestParam("fotoPerfil") MultipartFile file, @RequestParam("correo") String correo) {
        try {
            UsuarioModel usuario = usuarioRepository.findByCorreo(correo);
            if (usuario != null && !file.isEmpty()) {
                usuario.setFotoPerfil(file.getBytes());
                usuarioRepository.save(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/paginas/Perfil";
    }
}



