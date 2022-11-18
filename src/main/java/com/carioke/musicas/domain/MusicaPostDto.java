package com.carioke.musicas.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record MusicaPostDto(
        @NotBlank
        String titulo,
        @NotEmpty List<Long> compositores_ids){}