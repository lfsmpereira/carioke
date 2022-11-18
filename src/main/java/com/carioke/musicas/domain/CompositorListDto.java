package com.carioke.musicas.domain;

import java.util.List;

public record CompositorListDto(Long id, String nome, List<Musica> musicas) {

    public CompositorListDto(Compositor compositor) {
        this(compositor.getId(), compositor.getNome(), compositor.getMusicas());
    }
}
