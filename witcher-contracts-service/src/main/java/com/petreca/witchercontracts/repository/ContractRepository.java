package com.petreca.witchercontracts.repository;

import com.petreca.witchercontracts.model.Contract;
import com.petreca.witchercontracts.model.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByStatus(ContractStatus status);
    List<Contract> findByMonsterId(Long monsterId);
}