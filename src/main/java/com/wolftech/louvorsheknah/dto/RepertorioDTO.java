package com.wolftech.louvorsheknah.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wolftech.louvorsheknah.entity.Musica;
import com.wolftech.louvorsheknah.entity.Usuario;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataExecucao;
    private Usuario usuario;
    private String observacoes;
    private Set<Musica> musicas = new HashSet<>();

}