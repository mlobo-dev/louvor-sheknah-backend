package com.wolftech.louvorsheknah.dto;

import com.wolftech.louvorsheknah.entity.enums.Tipo;
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