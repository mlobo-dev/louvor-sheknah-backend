package com.dev4abyss.louvorsheknah.mapper;


import com.dev4abyss.louvorsheknah.dto.MusicaCadastroDTO;
import com.dev4abyss.louvorsheknah.entity.Musica;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusicaCadastroMapper extends BaseMapper<Musica, MusicaCadastroDTO> {

}