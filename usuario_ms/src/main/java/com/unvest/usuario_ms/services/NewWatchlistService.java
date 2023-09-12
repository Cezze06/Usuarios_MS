package com.unvest.usuario_ms.services;

import com.unvest.usuario_ms.entities.NewWatchlist;
import com.unvest.usuario_ms.repositories.NewWatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewWatchlistService {

    @Autowired
    private final NewWatchlistRepository newWatchlistRepository;


    public NewWatchlistService(NewWatchlistRepository newWatchlistRepository) {
        this.newWatchlistRepository = newWatchlistRepository;
    }

    public List<NewWatchlist> getAllNews() {
        return newWatchlistRepository.findAll();
    }

    public NewWatchlist getNewsById(Long id) {
        return newWatchlistRepository.findById(id).orElse(null);
    }

    public NewWatchlist createNew(NewWatchlist newWatchlist) {
        NewWatchlist newNWL = newWatchlistRepository.save(newWatchlist);
        return newNWL;
    }

    public NewWatchlist updateNew(Long id, NewWatchlist newWatchlist) {
        if (newWatchlistRepository.existsById(id)) {
            newWatchlist.setId_new(id);
            return newWatchlistRepository.save(newWatchlist);
        }
        else {
            return null;
        }
    }

    public void deleteNew(Long id) {
        newWatchlistRepository.deleteById(id);
    }
}
