package com.carioke.musicas.infrastructure.persistence;

import com.carioke.musicas.domain.Versao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersaoRepository extends JpaRepository<Versao, Long> {
}
