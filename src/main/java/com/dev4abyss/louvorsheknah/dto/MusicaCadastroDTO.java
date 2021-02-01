package com.dev4abyss.louvorsheknah.dto;

import com.dev4abyss.louvorsheknah.entity.enums.CategoriaEnum;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicaCadastroDTO implements Serializable {

    private Long id;

    @NotNull(message = "O Email é obrigatório")
    private String emailUsuario;

    @NotNull
    private String nome;

    private String urlCifra;
    private String urlVideo;
    private String urlAudio;
    private CategoriaEnum categoria;
    private String artista;
    private String letra;


}