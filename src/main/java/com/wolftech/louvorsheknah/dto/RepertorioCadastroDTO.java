package com.wolftech.louvorsheknah.dto;

import com.wolftech.louvorsheknah.entity.Musica;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepertorioCadastroDTO implements Serializable {

    private Long id;
    private String nome;
    private LocalDate dataExecucao;
    private String observacoes;

    @NotEmpty
    private Set<Musica> musicas = new HashSet<>();
    @NotNull
    private String emailUsuario;
}