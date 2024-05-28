package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.VariosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VariosRepository extends JpaRepository<VariosModel, Integer> {
    @Query("SELECT vario FROM VariosModel vario WHERE vario.idRegistro = :codigo")
    Page<VariosModel> findByMisobjetosV(@Param("codigo") Integer codigo, Pageable pageable);
}
