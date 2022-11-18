package com.carioke.musicas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Versao")
@Table(name = "versoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Versao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "musica_id")
    private Musica musica;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "versoes_interpretes",
            joinColumns = @JoinColumn(name = "versao_id"),
            inverseJoinColumns = @JoinColumn(name = "interprete_id")
    )
    private List<Interprete> interpretes;

    public Versao(Musica musica, List<Interprete> interpretes) {
        this.musica = musica;
        this.interpretes = interpretes;
    }

    public void addInterprete(Interprete interprete) {
        interpretes.add(interprete);
        interprete.getVersoes().add(this);
    }

    public void removeInterprete(Interprete interprete) {
        interpretes.remove(interprete);
        interprete.getVersoes().remove(this);
    }

}
