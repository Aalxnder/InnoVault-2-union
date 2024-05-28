package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.VariosModel;
import com.innovaultmy.app.models.FilamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface ObjetosUsuariosRepository extends JpaRepository<VariosModel, Long>
{
    @Query("SELECT vario FROM VariosModel vario WHERE vario.idRegistro = :codigo")
    Page<VariosModel> findByMisobjetosContaining(@Param("codigo") Integer codigo, Pageable pageable);
}

