package com.petreca.witchercontracts.dto;

import com.petreca.witchercontracts.model.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
    private Long id;
    private Long monsterId;
    private List<Long> requiredItemIds;
    private ContractStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}