package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.RepertorioDTO;
import com.wolftech.louvorsheknah.entity.Repertorio;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepertorioMapper extends BaseMapper<Repertorio, RepertorioDTO> {

}
