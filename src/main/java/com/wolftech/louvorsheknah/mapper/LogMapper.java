package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.LogDTO;
import com.wolftech.louvorsheknah.entity.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper extends BaseMapper<Log, LogDTO> {

}
