package com.petreca.bestiaryandarmory.controller;

import com.petreca.bestiaryandarmory.item.dto.CreateItemRequestDTO;
import com.petreca.bestiaryandarmory.item.dto.DeleteItemResponseDTO;
import com.petreca.bestiaryandarmory.item.dto.ItemDTO;
import com.petreca.bestiaryandarmory.item.dto.UpdateItemRequestDTO;
import com.petreca.bestiaryandarmory.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Tag(name = "Item Management", description = "Operations for managing items in the bestiary")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @Operation(summary = "Get all items", description = "Retrieve all items from the bestiary")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get item by ID", description = "Retrieve a specific item by its ID")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new item", description = "Add a new item to the bestiary")
    public ResponseEntity<ItemDTO> createItem(@Valid @RequestBody CreateItemRequestDTO requestDTO) {
        ItemDTO createdItem = itemService.createItem(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update item", description = "Update an existing item in the bestiary")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @Valid @RequestBody UpdateItemRequestDTO requestDTO) {
        return itemService.updateItem(id, requestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete item", description = "Remove an item from the bestiary")
    public ResponseEntity<DeleteItemResponseDTO> deleteItem(@PathVariable Long id) {
        if (itemService.deleteItem(id)) {
            DeleteItemResponseDTO response = new DeleteItemResponseDTO("Item deleted successfully", id);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}