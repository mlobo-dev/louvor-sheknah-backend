package com.dev4abyss.louvorsheknah.entity;

import com.dev4abyss.louvorsheknah.entity.enums.PerfilEnum;
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
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "LOGIN")
    private String login;

    @Enumerated(EnumType.STRING)
    @Column(name = "PERFIL")
    private PerfilEnum perfil;

}