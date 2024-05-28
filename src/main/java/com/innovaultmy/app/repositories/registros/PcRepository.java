package com.innovaultmy.app.repositories.registros;


import com.innovaultmy.app.models.ComputadoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcRepository extends JpaRepository<ComputadoraModel, Integer>
{
}
