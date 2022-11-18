package com.carioke.musicas.infrastructure.persistence;

import com.carioke.musicas.domain.Compositor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositorRepository extends JpaRepository<Compositor, Long> {
}
