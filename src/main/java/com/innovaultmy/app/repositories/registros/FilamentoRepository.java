package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.FilamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilamentoRepository extends JpaRepository<FilamentoModel, Integer> {
    @Query("SELECT filamento FROM FilamentoModel filamento WHERE filamento.idRegistro = :codigo")
    Page<FilamentoModel> findByMisobjetosF(@Param("codigo") Integer codigo, Pageable pageable);

}
