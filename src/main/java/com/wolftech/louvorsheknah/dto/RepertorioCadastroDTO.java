package com.wolftech.louvorsheknah.dto;

import com.wolftech.louvorsheknah.entity.Item;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class RepertorioCadastroDTO implements Serializable {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataExecucao;
    private String observacoes;

    @NotEmpty
    private Set<Item> items = new HashSet<>();
    @NotNull
    private Long idUsuario;
}