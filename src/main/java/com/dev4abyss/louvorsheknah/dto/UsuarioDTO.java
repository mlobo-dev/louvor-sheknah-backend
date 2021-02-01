package com.dev4abyss.louvorsheknah.dto;

import com.dev4abyss.louvorsheknah.entity.enums.PerfilEnum;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;

    @NotEmpty(message = "O nome é obrigatorio!")
    private String nome;

    @NotEmpty(message = "O cpf é brigatorio!")
    @CPF
    private String cpf;

    @Email
    @NotEmpty(message = "O email é brigatorio!")
    private String email;

    @NotEmpty(message = "A senha é brigatoria!")
    private String senha;

    @NotEmpty(message = "O Login é obrigatório!")
    private String login;

    @NotEmpty(message = "O Perfil é obrigatório!")
    private PerfilEnum perfil;

}
