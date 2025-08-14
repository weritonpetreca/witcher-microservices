package com.petreca.witchercontracts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateContractRequestDTO {
    @NotNull(message = "Monster ID is required")
    private Long monsterId;
    
    @NotEmpty(message = "At least one item is required")
    private List<Long> requiredItemIds;
}