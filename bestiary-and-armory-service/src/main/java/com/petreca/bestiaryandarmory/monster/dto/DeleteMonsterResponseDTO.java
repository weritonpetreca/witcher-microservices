package com.petreca.bestiaryandarmory.monster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMonsterResponseDTO {
    private String message;
    private Long monsterId;
}