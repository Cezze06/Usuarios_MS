package com.unvest.usuario_ms.controllers;

import com.unvest.usuario_ms.entities.StockWatchlist;
import com.unvest.usuario_ms.services.StockWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private final StockWatchlistService stockWatchlistService;

    public StockController(StockWatchlistService stockWatchlistService) {
        this.stockWatchlistService = stockWatchlistService;
    }

    @GetMapping
    public ResponseEntity<List<StockWatchlist>> getAllStocks() {
        List<StockWatchlist> stockWatchlists = stockWatchlistService.getAllStocks();
        if (stockWatchlists.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(stockWatchlists);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockWatchlist> getStockById(@PathVariable Long id) {
        StockWatchlist stockWatchlist = stockWatchlistService.getStockById(id);
        if (stockWatchlist == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(stockWatchlist);
        }
    }
    @PostMapping
    public ResponseEntity<StockWatchlist> saveStock(@RequestBody StockWatchlist stockWatchlist) {
        StockWatchlist newSWL = stockWatchlistService.createStock(stockWatchlist);
        return ResponseEntity.ok(newSWL);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockWatchlist> updateStock(@PathVariable Long id, @RequestBody StockWatchlist stockWatchlist) {
        StockWatchlist stockNWL = stockWatchlistService.updateStock(id, stockWatchlist);
        if (stockNWL == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(stockNWL);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockWatchlistService.deleteStock(id);
    }
}
