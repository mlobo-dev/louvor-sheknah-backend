package com.dev4abyss.louvorsheknah.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_REPERTORIO")
public class Repertorio implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REPERTORIO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_EXECUCAO")
    private LocalDate dataExecucao;

    @Column(name = "OBSERVACOES")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "TB_REPERTORIO_MUSICAS",
            joinColumns = @JoinColumn(name = "COD_REPERTORIO"),
            inverseJoinColumns = @JoinColumn(name = "COD_MUSICA")
    )
    private Set<Musica> musicas = new HashSet<>();


}