package com.dev4abyss.louvorsheknah.mapper;


import com.dev4abyss.louvorsheknah.dto.UsuarioDTO;
import com.dev4abyss.louvorsheknah.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}
