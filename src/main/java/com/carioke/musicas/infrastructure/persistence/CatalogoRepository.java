package com.carioke.musicas.infrastructure.persistence;

import com.carioke.musicas.domain.Catalogo;
import com.carioke.musicas.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
