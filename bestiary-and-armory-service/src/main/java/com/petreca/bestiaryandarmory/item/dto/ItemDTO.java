package com.petreca.bestiaryandarmory.item.dto;

import com.petreca.bestiaryandarmory.item.model.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private ItemType itemType;
    private BigDecimal price;
}