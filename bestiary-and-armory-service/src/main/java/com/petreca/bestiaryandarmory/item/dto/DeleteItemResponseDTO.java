package com.petreca.bestiaryandarmory.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteItemResponseDTO {
    private String message;
    private Long itemId;
}