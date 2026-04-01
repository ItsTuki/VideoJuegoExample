package com.juego.video.service;

import com.juego.video.model.Game;
import com.juego.video.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }

    public Game getById(Long id) {
        return this.gameRepository.findById(id);
    }

    public Game save(Game newGame) {
        return this.gameRepository.save(newGame);
    }

    public Game update(Game updatedGame) {
        return this.gameRepository.update(updatedGame);
    }

    public void delete(Long id) {
        this.gameRepository.deleteById(id);
    }

    public List<Game> getByGenre(String genre) {
        return this.gameRepository.filterByGenre(genre);
    }

    public List<Game> getByPlatform(String platform) {
        return this.gameRepository.filterByPlatform(platform);
    }

    public Game getCheapest() {
        return this.gameRepository.findCheapest();
    }

    public int getStockCount() {
        return this.gameRepository.countInStock();
    }
}
