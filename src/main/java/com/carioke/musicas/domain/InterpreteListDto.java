package com.carioke.musicas.domain;

import java.util.List;

public record InterpreteListDto(Long id, String nome, List<Versao> versoes) {

    public InterpreteListDto(Interprete interprete) {
        this(interprete.getId(), interprete.getNome(), interprete.getVersoes());
    }
}
