package com.petreca.bestiaryandarmory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    private BigDecimal price;

}
