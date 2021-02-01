package com.dev4abyss.louvorsheknah.mapper;


import com.dev4abyss.louvorsheknah.dto.RepertorioDTO;
import com.dev4abyss.louvorsheknah.entity.Repertorio;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepertorioMapper extends BaseMapper<Repertorio, RepertorioDTO> {

}
