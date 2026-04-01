package com.juego.video.repository;
import com.juego.video.model.JuegoDeMierda;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
@Repository
public class JuegoQlRepository {
    private List <JuegoDeMierda> listJuego = new ArrayList<>();

    public List<JuegoDeMierda> findAll(){
        return this.listJuego;
    }

    public List<JuegoDeMierda> findById(Long id) {
        for (JuegoDeMierda game: this.listJuego){
            if(Objects.equals(game.getId(),id)){
                return Collections.singletonList(game);
            }
        }
        return null;
    }
    public JuegoDeMierda save(JuegoDeMierda nuevoGame){
        JuegoDeMierda game = (JuegoDeMierda) this.findById(nuevoGame.getId());
        if (game == null){
            this.listJuego.add(nuevoGame);
            return nuevoGame;
        }else {
            throw new RuntimeException("ya esta ctm");
        }
    }

    public JuegoDeMierda update(JuegoDeMierda actuGame){
        int position = 0;
        boolean find = false;
        for(int i = 0; i < this.listJuego.size(); i++){
            if(this.listJuego.get(i).getId().equals(actuGame.getId())){
                position = i;
                find = true;
                break;
            }
        }
      if(find){
          this.listJuego.set(position,actuGame);
          return actuGame;
      }else{
          throw new RuntimeException("no existe");
      }
    }
    public void deleById(Long id){
        JuegoDeMierda cago = (JuegoDeMierda) this.findById(id);
        if(cago == null){
            throw new RuntimeException("no existe tu wea ctm");
        }
        this.listJuego.remove(cago);
    }

    public List<JuegoDeMierda> filtro(String genero){
        List<JuegoDeMierda> infiltrado = new ArrayList<>();
        for(JuegoDeMierda game: this.listJuego){
            if(game.getGenero().equalsIgnoreCase(genero)){
                infiltrado.add(game);
            }
        }
        return infiltrado;
    }

    public List<JuegoDeMierda> filtroplat(String platafroma){
        List<JuegoDeMierda> infiltrado = new ArrayList<>();
        for(JuegoDeMierda game: this.listJuego){
            if(game.getPlataforma().equalsIgnoreCase(platafroma)){
                infiltrado.add(game);
            }
        }
        return infiltrado;
    }
    public JuegoDeMierda masBarato(){
        JuegoDeMierda maBarato = this.listJuego.get(0);
        for (JuegoDeMierda game: this.listJuego){
            if (game.getPrecio() < maBarato.getPrecio()){
                maBarato = game;
            }
        }
        return maBarato;
    }

    public int countStock (){
        int contador = 0;
        for (JuegoDeMierda game: this.listJuego){
            if(game.getStock() > 0){
                contador++;
            }
        }
        return contador;
    }
}
