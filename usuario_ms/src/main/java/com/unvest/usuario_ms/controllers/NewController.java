package com.unvest.usuario_ms.controllers;

import com.unvest.usuario_ms.entities.NewWatchlist;
import com.unvest.usuario_ms.services.NewWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NewController {
    @Autowired
    private final NewWatchlistService newWatchlistService;

    public NewController(NewWatchlistService newWatchlistService) {
        this.newWatchlistService = newWatchlistService;
    }
    @GetMapping
    public ResponseEntity<List<NewWatchlist>> getAllNews() {
        List<NewWatchlist> newWatchlist = newWatchlistService.getAllNews();
        if (newWatchlist.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(newWatchlist);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewWatchlist> getNewById(@PathVariable Long id) {
        NewWatchlist newWatchlist = newWatchlistService.getNewsById(id);
        if (newWatchlist == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newWatchlist);
    }

    @PostMapping
    public ResponseEntity<NewWatchlist> saveNew(@RequestBody NewWatchlist newWatchlist) {
        NewWatchlist newWL = newWatchlistService.createNew(newWatchlist);
        return ResponseEntity.ok(newWL);
    }

    @PutMapping
    public ResponseEntity<NewWatchlist> updateNew(@PathVariable Long id, @RequestBody NewWatchlist newWatchlist) {
        NewWatchlist newWL = newWatchlistService.updateNew(id, newWatchlist);
        if (newWL == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newWL);
    }

    @DeleteMapping("/{id}")
    public void deleteNewId(@PathVariable Long id) {
        newWatchlistService.deleteNew(id);
    }
}
