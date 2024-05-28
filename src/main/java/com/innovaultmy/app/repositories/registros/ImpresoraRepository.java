package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.ImpresoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpresoraRepository extends JpaRepository<ImpresoraModel, Integer>
{
}
