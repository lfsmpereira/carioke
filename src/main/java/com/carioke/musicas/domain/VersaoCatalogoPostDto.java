package com.carioke.musicas.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VersaoCatalogoPostDto(
        @NotNull
        Long codigo,
        @NotNull
        Long versao_id,
        @NotNull
        Long catalogo_id){}