package com.wolftech.louvorsheknah.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepertorioCadastroDTO implements Serializable {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataExecucao;
    private String observacoes;
    @NotNull
    private Long idUsuario;
}