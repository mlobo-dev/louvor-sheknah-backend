package com.wolftech.louvorsheknah.dto;
import com.wolftech.louvorsheknah.entity.enums.CategoriaEnum;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCadastroDTO implements Serializable {
	private Long id;

	@NotNull
	private Long idUsuario;

	@NotNull
	private String nome;

	private String urlCifra;
	private String urlVideo;
	private String urlAudio;
	private CategoriaEnum categoriaEnum;
	private String artista;
	private String letra;


}