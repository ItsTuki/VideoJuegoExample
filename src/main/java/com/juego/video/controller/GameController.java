package com.juego.video.controller;

import com.juego.video.model.Game;
import com.juego.video.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.gameService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        try {
            Game game = this.gameService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(game);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Game> save(@Valid @RequestBody Game newGame) {
        try {
            Game savedGame = this.gameService.save(newGame);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<Game> update(@Valid @RequestBody Game updatedGame) {
        try {
            Game game = this.gameService.update(updatedGame);
            return ResponseEntity.status(HttpStatus.OK).body(game);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            this.gameService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Game>> getByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(this.gameService.getByGenre(genre));
    }

    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<Game>> getByPlatform(@PathVariable String platform) {
        return ResponseEntity.ok(this.gameService.getByPlatform(platform));
    }

    @GetMapping("/cheapest")
    public ResponseEntity<Game> getCheapest() {
        try {
            Game cheapestGame = this.gameService.getCheapest();
            return ResponseEntity.ok(cheapestGame);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/stock-count")
    public ResponseEntity<Integer> getStockCount() {
        return ResponseEntity.ok(this.gameService.getStockCount());
    }
}
