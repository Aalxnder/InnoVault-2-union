package com.innovaultmy.app.service.usuarios;

import com.innovaultmy.app.models.UsuarioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService  {

    void registrarUsuario(UsuarioModel usuario);

    Page<UsuarioModel> listaUsuarios(Pageable pageable);

    void borrar (UsuarioModel usuario);

    UsuarioModel buscarPorId(Integer id);
    void actualizarUsuario(UsuarioModel usuario);

    boolean verificarCredenciales(String correo, String contrasenia);

    UsuarioModel findByCorreo(String correo);
}