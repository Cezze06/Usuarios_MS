package com.unvest.usuario_ms.repositories;

import com.unvest.usuario_ms.entities.NewWatchlist;
import com.unvest.usuario_ms.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewWatchlistRepository extends JpaRepository<NewWatchlist, Long> {
}
