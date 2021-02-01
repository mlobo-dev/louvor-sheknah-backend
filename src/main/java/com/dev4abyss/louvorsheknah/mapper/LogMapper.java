package com.dev4abyss.louvorsheknah.mapper;


import com.dev4abyss.louvorsheknah.dto.LogDTO;
import com.dev4abyss.louvorsheknah.entity.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper extends BaseMapper<Log, LogDTO> {

}
