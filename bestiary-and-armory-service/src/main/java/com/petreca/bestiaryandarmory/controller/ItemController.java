package com.petreca.bestiaryandarmory.controller;


import com.petreca.bestiaryandarmory.model.Item;
import com.petreca.bestiaryandarmory.mappers.ItemMapper;
import com.petreca.bestiaryandarmory.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Operation(summary = "Create a new item", description = "Adds a new item to the bestiary and armory.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data for item creation")
    })
    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@Valid @RequestBody CreateItemRequestDTO requestDTO) {
        Item createdItem = itemService.createItem(requestDTO);
        ItemDTO createdItemDTO = itemMapper.toDTO(createdItem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdItem.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdItemDTO);
    }

    @Operation(summary = "Get all items", description = "Returns a list of all available items.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of items")
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> itemsDTO = itemService.getAllItems().stream()
                .map(itemMapper::toDTO).toList();
        return ResponseEntity.ok(itemsDTO);
    }

    @Operation(summary = "Get an item by ID", description = "Returns a single item based on its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved item"),
            @ApiResponse(responseCode = "404", description = "Item not found with the given ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(itemMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
