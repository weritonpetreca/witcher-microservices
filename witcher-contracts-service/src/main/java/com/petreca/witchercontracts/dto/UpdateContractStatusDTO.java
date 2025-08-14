package com.petreca.witchercontracts.dto;

import com.petreca.witchercontracts.model.ContractStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContractStatusDTO {
    @NotNull(message = "Status is required")
    private ContractStatus status;
}