package com.carioke.musicas.domain;

import jakarta.validation.constraints.NotBlank;

public record CatalogoPostDto(

        @NotBlank
        String nome){}