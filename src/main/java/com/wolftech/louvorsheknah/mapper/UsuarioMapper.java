package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.UsuarioDTO;
import com.wolftech.louvorsheknah.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}
