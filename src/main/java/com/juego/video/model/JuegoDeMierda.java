package com.juego.video.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegoDeMierda {

    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    @NotBlank(message = "ponle titulo ctm")
    private String titulo;

    @NotBlank(message = "pon algo")
    private String genero;

    @NotBlank(message = "pon algo")
    private String plataforma;

    @NotNull(message = "ctm pon algo")
    @Positive(message = "pon un numero positivo ctm ")
    private Double precio;

    @NotNull(message = "pon cualquier wea")
    @PositiveOrZero(message = "como no vas a tener algo ctm")
    private Integer stock;

    @NotBlank(message = "pon algo")
    private String desarrollador;
}