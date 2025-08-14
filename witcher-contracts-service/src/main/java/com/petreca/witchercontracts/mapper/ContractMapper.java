package com.petreca.witchercontracts.mapper;

import com.petreca.witchercontracts.dto.ContractDTO;
import com.petreca.witchercontracts.model.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractDTO toDTO(Contract contract);
    Contract toEntity(ContractDTO contractDTO);
}