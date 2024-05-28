package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>
{
    @Query("SELECT u FROM UsuarioModel u WHERE u.correo = :correo")
    UsuarioModel findByCorreo(@Param("correo") String correo);
}
