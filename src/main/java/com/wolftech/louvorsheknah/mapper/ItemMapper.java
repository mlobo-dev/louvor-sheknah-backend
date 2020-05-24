package com.wolftech.louvorsheknah.mapper;


import com.wolftech.louvorsheknah.dto.ItemDTO;
import com.wolftech.louvorsheknah.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper extends BaseMapper<Item, ItemDTO> {

}
