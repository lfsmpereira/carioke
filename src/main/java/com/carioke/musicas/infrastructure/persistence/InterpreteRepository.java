package com.carioke.musicas.infrastructure.persistence;

import com.carioke.musicas.domain.Interprete;
import com.carioke.musicas.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterpreteRepository extends JpaRepository<Interprete, Long> {
}
