package com.carioke.musicas.domain;

import jakarta.validation.constraints.NotBlank;

public record InterpretePostDto(

        @NotBlank
        String nome){}