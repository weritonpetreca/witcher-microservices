package com.petreca.bestiaryandarmory.item.mapper;

import com.petreca.bestiaryandarmory.item.dto.ItemDTO;
import com.petreca.bestiaryandarmory.item.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO itemDTO);
}