package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.ObjetosEliminados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EliminarObjetosRepository extends JpaRepository<ObjetosEliminados, Integer>
{
}
