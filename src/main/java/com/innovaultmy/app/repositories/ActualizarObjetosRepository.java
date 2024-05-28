package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.ObjetosActualizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualizarObjetosRepository extends JpaRepository<ObjetosActualizados, Integer> {
}
