package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.MantenimientoComputadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoComputadoraRepository extends JpaRepository<MantenimientoComputadora, Integer>
{
}
