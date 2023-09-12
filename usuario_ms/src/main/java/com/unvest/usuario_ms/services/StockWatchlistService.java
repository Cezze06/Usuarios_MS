package com.unvest.usuario_ms.services;

import com.unvest.usuario_ms.entities.StockWatchlist;
import com.unvest.usuario_ms.repositories.StockWatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockWatchlistService {
    @Autowired
    private final StockWatchlistRepository stockWatchlistRepository;

    public StockWatchlistService(StockWatchlistRepository stockWatchlistRepository) {
        this.stockWatchlistRepository = stockWatchlistRepository;
    }

    public List<StockWatchlist> getAllStocks() {
        return stockWatchlistRepository.findAll();
    }
    public StockWatchlist getStockById(Long id) {
        return stockWatchlistRepository.findById(id).orElse(null);
    }
    public StockWatchlist createStock(StockWatchlist stockWatchlist) {
        StockWatchlist newSWL = stockWatchlistRepository.save(stockWatchlist);
        return newSWL;
    }
    public StockWatchlist updateStock(Long id, StockWatchlist stockWatchlist) {
        if (stockWatchlistRepository.existsById(id)) {
            stockWatchlist.setId_stock(id);
            return stockWatchlistRepository.save(stockWatchlist);
        }
        else {
            return null;
        }
    }
    public void deleteStock(Long id) {
        stockWatchlistRepository.deleteById(id);
    }
}
