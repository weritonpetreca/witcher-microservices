package com.petreca.bestiaryandarmory.mappers;

import com.petreca.bestiaryandarmory.controller.ItemDTO;
import com.petreca.bestiaryandarmory.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDTO toDTO(Item item) {
        if (item == null) {
            return null;
        }
        return new ItemDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getItemType(),
                item.getPrice()
        );
    }
}