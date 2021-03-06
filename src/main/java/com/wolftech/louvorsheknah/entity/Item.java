package com.wolftech.louvorsheknah.entity;
import com.wolftech.louvorsheknah.entity.enums.CategoriaEnum;
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
@Table(name = "TB_ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ITEM")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "URL_CIFRA")
	private String urlCifra;

	@Column(name = "URL_VIDEO")
	private String urlVideo;

	@Column(name = "URL_AUDIO")
	private String urlAudio;

	@Column(name = "LETRA")
	private String letra;

	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORIA")
	private CategoriaEnum categoriaEnum;

	@Column(name = "ARTISTA")
	private String artista;

}