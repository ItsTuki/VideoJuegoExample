package com.juego.video.service;

import com.juego.video.repository.JuegoQlRepository;
import com.juego.video.model.JuegoDeMierda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Juegoservice {

    @Autowired
    private JuegoQlRepository juego;
    public List<JuegoDeMierda> getAll() {
        return this.juego.findAll();
    }

    public JuegoDeMierda getById(Long id) {
        return this.juego.findById(id);
    }

    public JuegoDeMierda save(JuegoDeMierda nuevo) {
        return this.juego.save(nuevo);
    }

    public JuegoDeMierda update(JuegoDeMierda actu) {
        return this.juego.update(actu);
    }

    public void delete(Long id) {
        this.juego.deleById(id);
    }

    public List<JuegoDeMierda> getByGenero(String genero) {
        return this.juego.filtro(genero);
    }

    public List<JuegoDeMierda> getByPlataforma(String plataforma) {
        return this.juego.filtroplat(plataforma);
    }

    public JuegoDeMierda getMasBarato() {
        return this.juego.masBarato();
    }

    public int getCountStock() {
        return this.juego.countStock();
    }
}