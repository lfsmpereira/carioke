package com.carioke.musicas.domain;

import jakarta.validation.constraints.NotBlank;

public record CompositorPostDto(

        @NotBlank
        String nome){}