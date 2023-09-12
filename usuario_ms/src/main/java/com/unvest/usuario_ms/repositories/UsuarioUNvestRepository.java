package com.unvest.usuario_ms.repositories;

import com.unvest.usuario_ms.entities.UsuarioUNvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioUNvestRepository extends JpaRepository<UsuarioUNvest, Long> {
}
