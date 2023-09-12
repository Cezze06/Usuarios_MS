package com.unvest.usuario_ms.repositories;

import com.unvest.usuario_ms.entities.Perfil;
import com.unvest.usuario_ms.entities.StockWatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockWatchlistRepository extends JpaRepository<StockWatchlist, Long> {
}
