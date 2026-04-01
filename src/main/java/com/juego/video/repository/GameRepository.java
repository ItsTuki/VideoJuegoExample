package com.juego.video.repository;

import com.juego.video.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
public class GameRepository {
    private final List<Game> gameList = new ArrayList<>();

    public List<Game> findAll() {
        return new ArrayList<>(this.gameList); // Return copy to prevent external modification
    }

    public Game findById(Long id) {
        for (Game game : this.gameList) {
            if (Objects.equals(game.getId(), id)) {
                return game;
            }
        }
        throw new NoSuchElementException("Game with ID " + id + " not found");
    }

    public Game save(Game newGame) {
        // Check if ID already exists
        boolean exists = this.gameList.stream().anyMatch(g -> g.getId().equals(newGame.getId()));
        if (exists) {
            throw new IllegalArgumentException("Game with ID " + newGame.getId() + " already exists");
        }
        this.gameList.add(newGame);
        return newGame;
    }

    public Game update(Game updatedGame) {
        for (int i = 0; i < this.gameList.size(); i++) {
            if (this.gameList.get(i).getId().equals(updatedGame.getId())) {
                this.gameList.set(i, updatedGame);
                return updatedGame;
            }
        }
        throw new NoSuchElementException("Game with ID " + updatedGame.getId() + " not found for update");
    }

    public void deleteById(Long id) {
        Game gameToDelete = this.findById(id); // Throws NoSuchElementException if not found
        this.gameList.remove(gameToDelete);
    }

    public List<Game> filterByGenre(String genre) {
        List<Game> filtered = new ArrayList<>();
        for (Game game : this.gameList) {
            if (game.getGenre().equalsIgnoreCase(genre)) {
                filtered.add(game);
            }
        }
        return filtered;
    }

    public List<Game> filterByPlatform(String platform) {
        List<Game> filtered = new ArrayList<>();
        for (Game game : this.gameList) {
            if (game.getPlatform().equalsIgnoreCase(platform)) {
                filtered.add(game);
            }
        }
        return filtered;
    }

    public Game findCheapest() {
        if (this.gameList.isEmpty()) {
            throw new NoSuchElementException("No games available");
        }
        Game cheapest = this.gameList.get(0);
        for (Game game : this.gameList) {
            if (game.getPrice() < cheapest.getPrice()) {
                cheapest = game;
            }
        }
        return cheapest;
    }

    public int countInStock() {
        int count = 0;
        for (Game game : this.gameList) {
            if (game.getStock() > 0) {
                count++;
            }
        }
        return count;
    }
}
