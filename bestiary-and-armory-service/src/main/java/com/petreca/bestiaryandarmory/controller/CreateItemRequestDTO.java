package com.petreca.bestiaryandarmory.controller;

import com.petreca.bestiaryandarmory.model.ItemType;

import java.math.BigDecimal;

public record CreateItemRequestDTO(
        String name,
        String description,
        ItemType itemType,
        BigDecimal price
) {}