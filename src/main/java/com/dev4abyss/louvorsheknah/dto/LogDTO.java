package com.dev4abyss.louvorsheknah.dto;

import com.dev4abyss.louvorsheknah.entity.enums.Tipo;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogDTO implements Serializable {

    private Long id;
    private String descricao;
    private Tipo tipo;
    private String autor;
    private Long idObjeto;

}