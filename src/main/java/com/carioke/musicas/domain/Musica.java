package com.carioke.musicas.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Musica")
@Table(name = "musicas")
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "musicas_compositores",
            joinColumns = @JoinColumn(name = "musica_id"),
            inverseJoinColumns = @JoinColumn(name = "compositor_id")
    )
    private List<Compositor> compositores;

    public Musica(String titulo, List<Compositor> compositores) {
        this.titulo = titulo;
        this.compositores = compositores;
    }

    public void addCompositor(Compositor compositor) {
        compositores.add(compositor);
        compositor.getMusicas().add(this);
    }

    public void removeCompositor(Compositor compositor) {
        compositores.remove(compositor);
        compositor.getMusicas().remove(this);
    }

}
