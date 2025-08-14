package com.petreca.bestiaryandarmory.item.dto;

import com.petreca.bestiaryandarmory.item.model.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemRequestDTO {
    @NotBlank(message = "Item name is required")
    private String name;
    
    private String description;
    
    @NotNull(message = "Item type is required")
    private ItemType itemType;
    
    @PositiveOrZero(message = "Price must be positive or zero")
    private BigDecimal price;
}