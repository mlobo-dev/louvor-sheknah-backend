package com.wolftech.louvorsheknah.dto;

import com.wolftech.louvorsheknah.entity.Item;
import com.wolftech.louvorsheknah.entity.Usuario;
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
public class RepertorioDTO implements Serializable {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataExecucao;
    private Usuario usuario;
    private String observacoes;
    private Set<Item> items = new HashSet<>();

}