package com.juego.video.controller;

import com.juego.video.service.Juegoservice;
import com.juego.video.model.JuegoDeMierda;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/games")
public class controllerJuego {

    @Autowired
    private Juegoservice juegoservice;

    @GetMapping
    public ResponseEntity<List<JuegoDeMierda>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.juegoservice.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoDeMierda> getById(@PathVariable Long id) {
        JuegoDeMierda game = this.juegoservice.getById(id);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @PostMapping
    public ResponseEntity<JuegoDeMierda> save(@Valid @RequestBody JuegoDeMierda nuevoGame) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.juegoservice.save(nuevoGame));
    }

    @PutMapping
    public ResponseEntity<JuegoDeMierda> update(@Valid @RequestBody JuegoDeMierda actuGame) {
        return ResponseEntity.status(HttpStatus.OK).body(this.juegoservice.update(actuGame));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.juegoservice.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<JuegoDeMierda>> getByGenero(@PathVariable String genero) {
        return ResponseEntity.ok(this.juegoservice.getByGenero(genero));
    }

    @GetMapping("/filtro/{plataforma}")
    public ResponseEntity<List<JuegoDeMierda>> getByPlataforma(@PathVariable String plataforma) {
        return ResponseEntity.ok(this.juegoservice.getByPlataforma(plataforma));
    }

    @GetMapping("/mas-barato")
    public ResponseEntity<JuegoDeMierda> getMasBarato() {
        return ResponseEntity.ok(this.juegoservice.getMasBarato());
    }

    @GetMapping("/conteo-stock")
    public ResponseEntity<Integer> getCountStock() {
        return ResponseEntity.ok(this.juegoservice.getCountStock());
    }
}