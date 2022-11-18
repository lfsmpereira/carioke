package com.carioke.musicas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "VersaoCatalogo")
@Table(name = "catalogos_versoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class VersaoCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "versao_id")
    private Versao versao;

    public VersaoCatalogo(Long codigo, Catalogo catalogo, Versao versao) {
        this.codigo = codigo;
        this.catalogo = catalogo;
        this.versao = versao;
    }
}
