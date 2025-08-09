package com.petreca.bestiaryandarmory.mappers;

import com.petreca.bestiaryandarmory.controller.ItemDTO;
import com.petreca.bestiaryandarmory.controller.CreateItemRequestDTO;
import com.petreca.bestiaryandarmory.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO toDTO(Item item);
    Item toEntity(CreateItemRequestDTO dto);
}