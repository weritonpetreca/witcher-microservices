package com.petreca.bestiaryandarmory.item.service;

import com.petreca.bestiaryandarmory.item.dto.CreateItemRequestDTO;
import com.petreca.bestiaryandarmory.item.dto.ItemDTO;
import com.petreca.bestiaryandarmory.item.dto.UpdateItemRequestDTO;
import com.petreca.bestiaryandarmory.item.mapper.ItemMapper;
import com.petreca.bestiaryandarmory.item.model.Item;
import com.petreca.bestiaryandarmory.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::toDTO)
                .toList();
    }

    public Optional<ItemDTO> getItemById(Long id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDTO);
    }

    public ItemDTO createItem(CreateItemRequestDTO requestDTO) {
        Item item = new Item();
        item.setName(requestDTO.getName());
        item.setDescription(requestDTO.getDescription());
        item.setItemType(requestDTO.getItemType());
        item.setPrice(requestDTO.getPrice());
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDTO(savedItem);
    }

    public Optional<ItemDTO> updateItem(Long id, UpdateItemRequestDTO requestDTO) {
        return itemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(requestDTO.getName());
                    existingItem.setDescription(requestDTO.getDescription());
                    existingItem.setItemType(requestDTO.getItemType());
                    existingItem.setPrice(requestDTO.getPrice());
                    return itemMapper.toDTO(itemRepository.save(existingItem));
                });
    }

    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}