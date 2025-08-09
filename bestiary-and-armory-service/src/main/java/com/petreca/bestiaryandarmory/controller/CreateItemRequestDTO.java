package com.petreca.bestiaryandarmory.controller;

import com.petreca.bestiaryandarmory.model.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateItemRequestDTO(
        @NotBlank(message = "Item name cannot be blank")
        String name,
        String description,
        @NotNull(message = "Item type cannot be null")
        ItemType itemType,
        @NotNull(message = "Price cannot be null") @PositiveOrZero(message = "Price must be zero or positive")
        BigDecimal price
) {}