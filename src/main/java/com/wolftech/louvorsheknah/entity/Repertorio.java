package com.wolftech.louvorsheknah.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    private Date dataCriacao;

    @Column(name = "DATA_EXECUCAO")
    private Date dataExecucao;

    @Column(name = "OBSERVACOES")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "TB_REPERTORIO_ITEM",
            joinColumns = @JoinColumn(name = "COD_REPERTORIO"),
            inverseJoinColumns = @JoinColumn(name = "COD_ITEM")
    )
    private Set<Item> items = new HashSet<>();


}