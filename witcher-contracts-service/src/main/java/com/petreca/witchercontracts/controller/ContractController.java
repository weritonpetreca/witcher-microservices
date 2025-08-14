package com.petreca.witchercontracts.controller;

import com.petreca.witchercontracts.dto.ContractDTO;
import com.petreca.witchercontracts.dto.CreateContractRequestDTO;
import com.petreca.witchercontracts.dto.UpdateContractStatusDTO;
import com.petreca.witchercontracts.model.ContractStatus;
import com.petreca.witchercontracts.service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
@Tag(name = "Contract Management", description = "Operations for managing witcher contracts")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    @Operation(summary = "Get all contracts", description = "Retrieve all contracts")
    public ResponseEntity<List<ContractDTO>> getAllContracts() {
        List<ContractDTO> contracts = contractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get contract by ID", description = "Retrieve a specific contract by its ID")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable Long id) {
        return contractService.getContractById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get contracts by status", description = "Retrieve contracts filtered by status")
    public ResponseEntity<List<ContractDTO>> getContractsByStatus(@PathVariable ContractStatus status) {
        List<ContractDTO> contracts = contractService.getContractsByStatus(status);
        return ResponseEntity.ok(contracts);
    }

    @PostMapping
    @Operation(summary = "Create new contract", description = "Create a new witcher contract")
    public ResponseEntity<ContractDTO> createContract(@Valid @RequestBody CreateContractRequestDTO requestDTO) {
        try {
            ContractDTO createdContract = contractService.createContract(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContract);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update contract status", description = "Update the status of an existing contract")
    public ResponseEntity<ContractDTO> updateContractStatus(@PathVariable Long id, @Valid @RequestBody UpdateContractStatusDTO statusDTO) {
        return contractService.updateContractStatus(id, statusDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete contract", description = "Delete a contract")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        if (contractService.deleteContract(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
