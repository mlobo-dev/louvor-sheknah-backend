package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.MusicaCadastroDTO;
import com.wolftech.louvorsheknah.entity.Musica;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemCadastroMapper extends BaseMapper<Musica, MusicaCadastroDTO> {

}
