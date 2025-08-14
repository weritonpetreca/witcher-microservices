package com.petreca.bestiaryandarmory.monster.dto;

import com.petreca.bestiaryandarmory.monster.model.MonsterType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMonsterRequestDTO {

    @NotBlank(message = "Monster name is required")
    private String name;

    private String description;

    @NotNull(message = "Monster type is required")
    private MonsterType monsterType;

    private String weakness;

    private String habitat;

    private Integer dangerLevel;
}