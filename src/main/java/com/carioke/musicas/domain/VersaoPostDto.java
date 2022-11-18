package com.carioke.musicas.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VersaoPostDto(
        @NotNull
        Long musica_id,
        @NotEmpty List<Long> interpretes_ids){}