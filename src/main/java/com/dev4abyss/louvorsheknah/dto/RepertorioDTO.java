package com.dev4abyss.louvorsheknah.dto;

import com.dev4abyss.louvorsheknah.entity.Musica;
import com.dev4abyss.louvorsheknah.entity.Usuario;
import lombok.*;

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
public class RepertorioDTO implements Serializable {

    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDate dataExecucao;
    private Usuario usuario;
    private String observacoes;
    private Set<Musica> musicas = new HashSet<>();

}