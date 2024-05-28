package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.MantenimientoImpresora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoImpresoraRepository extends JpaRepository<MantenimientoImpresora, Integer>
{
}
