package com.innovaultmy.app.service.usuarios;

import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.repositories.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ImpUsuarioService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public ImpUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    @Transactional
    public void registrarUsuario(UsuarioModel usuario)
    {
        usuario.setFechaRegistro(new Date());
        usuarioRepository.save(usuario);
    }
    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioModel> listaUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void borrar(UsuarioModel usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioModel buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }


    @Override
    @Transactional()
    public boolean verificarCredenciales(String correo, String contrasenia)
    {
        UsuarioModel usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null)
        {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if(argon2.verify(usuario.getContrasenia(), contrasenia))
            {
                return true;
            }
        }
        return false;
    }
    @Override
    @Transactional(readOnly = true)
    public UsuarioModel findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }



}