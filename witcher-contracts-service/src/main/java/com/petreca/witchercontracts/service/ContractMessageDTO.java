package com.petreca.witchercontracts.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractMessageDTO {
    private String monster;
    private List<Long> items;
}