package com.petreca.bestiaryandarmory.service;

import com.petreca.bestiaryandarmory.mappers.ItemMapper;
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
    private final ItemMapper itemMapper;

    public Item createItem(CreateItemRequestDTO requestDTO) {
        Item newItem = itemMapper.toEntity(requestDTO);
        return itemRepository.save(newItem);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long Id) {
        return itemRepository.findById(Id);
    }
}
