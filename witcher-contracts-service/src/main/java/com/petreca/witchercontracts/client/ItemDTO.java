package com.petreca.witchercontracts.client;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String itemType;
}
