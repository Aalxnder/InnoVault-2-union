package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.FilamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoBusquedaRepository extends JpaRepository<FilamentoModel, Long>
{
    @Query("SELECT d FROM FilamentoModel d WHERE d.nombre LIKE %:nombre%")
    Page<FilamentoModel>findByNombreProductoContaining(@Param("nombre") String nombre, Pageable pageable);

}
