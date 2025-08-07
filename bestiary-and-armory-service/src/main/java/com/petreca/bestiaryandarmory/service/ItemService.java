package com.petreca.bestiaryandarmory.service;

import com.petreca.bestiaryandarmory.controller.CreateItemRequestDTO;
import com.petreca.bestiaryandarmory.model.Item;
import com.petreca.bestiaryandarmory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item createItem(CreateItemRequestDTO requestDTO) {
        Item newItem = new Item();
        newItem.setName(requestDTO.name());
        newItem.setDescription(requestDTO.description());
        newItem.setItemType(requestDTO.itemType());
        newItem.setPrice(requestDTO.price());
        return itemRepository.save(newItem);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long Id) {
        return itemRepository.findById(Id);
    }
}
