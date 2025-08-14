package com.petreca.bestiaryandarmory.controller;

import com.petreca.bestiaryandarmory.monster.dto.CreateMonsterRequestDTO;
import com.petreca.bestiaryandarmory.monster.dto.DeleteMonsterResponseDTO;
import com.petreca.bestiaryandarmory.monster.dto.MonsterDTO;
import com.petreca.bestiaryandarmory.monster.dto.UpdateMonsterRequestDTO;
import com.petreca.bestiaryandarmory.monster.service.MonsterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
@RequiredArgsConstructor
@Tag(name = "Monster Management", description = "Operations for managing monsters in the bestiary")
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping
    @Operation(summary = "Get all monsters", description = "Retrieve all monsters from the bestiary")
    public ResponseEntity<List<MonsterDTO>> getAllMonsters() {
        List<MonsterDTO> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get monster by ID", description = "Retrieve a specific monster by its ID")
    public ResponseEntity<MonsterDTO> getMonsterById(@PathVariable Long id) {
        return monsterService.getMonsterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new monster", description = "Add a new monster to the bestiary")
    public ResponseEntity<MonsterDTO> createMonster(@Valid @RequestBody CreateMonsterRequestDTO requestDTO) {
        MonsterDTO createdMonster = monsterService.createMonster(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonster);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update monster", description = "Update an existing monster in the bestiary")
    public ResponseEntity<MonsterDTO> updateMonster(@PathVariable Long id, @Valid @RequestBody UpdateMonsterRequestDTO requestDTO) {
        return monsterService.updateMonster(id, requestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete monster", description = "Remove a monster from the bestiary")
    public ResponseEntity<DeleteMonsterResponseDTO> deleteMonster(@PathVariable Long id) {
        if (monsterService.deleteMonster(id)) {
            DeleteMonsterResponseDTO response = new DeleteMonsterResponseDTO("Monster deleted successfully", id);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}