package com.carioke.musicas.infrastructure.persistence;

import com.carioke.musicas.domain.VersaoCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersaoCatalogoRepository extends JpaRepository<VersaoCatalogo, Long> {
}
