package com.dev4abyss.louvorsheknah.dto;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAuthDTO {

    private String emailOuLogin;
    private String senha;
}
