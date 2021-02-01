package com.dev4abyss.louvorsheknah.mapper;


import com.dev4abyss.louvorsheknah.dto.RepertorioCadastroDTO;
import com.dev4abyss.louvorsheknah.entity.Repertorio;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepertorioCadastroMapper extends BaseMapper<Repertorio, RepertorioCadastroDTO> {

}
