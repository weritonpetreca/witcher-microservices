package com.petreca.bestiaryandarmory.controller;


import com.petreca.bestiaryandarmory.model.Item;
import com.petreca.bestiaryandarmory.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody CreateItemRequestDTO requestDTO) {
        Item createdItem = itemService.createItem(requestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdItem.getId())
                .toUri();
        return ResponseEntity.created(location).body(toDTO(createdItem));
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> itemsDTO = itemService.getAllItems().stream()
                .map(this::toDTO).toList();
        return ResponseEntity.ok(itemsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private ItemDTO toDTO(Item item){
        return new ItemDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getItemType(),
                item.getPrice()
        );
    }
}
