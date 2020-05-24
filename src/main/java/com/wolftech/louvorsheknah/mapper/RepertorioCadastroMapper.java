package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.RepertorioCadastroDTO;
import com.wolftech.louvorsheknah.entity.Repertorio;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepertorioCadastroMapper extends BaseMapper<Repertorio, RepertorioCadastroDTO> {

}
