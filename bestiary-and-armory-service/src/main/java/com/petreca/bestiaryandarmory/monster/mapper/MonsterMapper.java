package com.petreca.bestiaryandarmory.monster.mapper;

import com.petreca.bestiaryandarmory.monster.dto.MonsterDTO;
import com.petreca.bestiaryandarmory.monster.model.Monster;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonsterMapper {
    MonsterDTO toDTO(Monster monster);
    Monster toEntity(MonsterDTO monsterDTO);
}