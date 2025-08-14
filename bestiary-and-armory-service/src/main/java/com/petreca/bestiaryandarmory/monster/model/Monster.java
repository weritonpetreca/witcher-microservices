package com.petreca.bestiaryandarmory.monster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monsters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Monster name is required")
    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @NotNull(message = "Monster type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterType monsterType;

    @Column
    private String weakness;

    @Column
    private String habitat;

    @Column
    private Integer dangerLevel;
}