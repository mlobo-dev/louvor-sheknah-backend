package com.dev4abyss.louvorsheknah.entity;

import com.dev4abyss.louvorsheknah.entity.enums.Tipo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_LOG")
public class Log implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_LOG")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private Tipo tipo;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "ID_OBJETO")
    private Long idObjeto;


}