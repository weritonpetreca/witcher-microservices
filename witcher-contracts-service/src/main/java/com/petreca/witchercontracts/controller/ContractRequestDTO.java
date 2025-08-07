package com.petreca.witchercontracts.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContractRequestDTO {
    private String monsterName;
    private List<Long> requiredItemIds = new ArrayList<>();
}
