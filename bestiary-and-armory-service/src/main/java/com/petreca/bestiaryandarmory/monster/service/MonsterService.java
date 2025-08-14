package com.petreca.bestiaryandarmory.monster.service;

import com.petreca.bestiaryandarmory.monster.dto.CreateMonsterRequestDTO;
import com.petreca.bestiaryandarmory.monster.dto.MonsterDTO;
import com.petreca.bestiaryandarmory.monster.dto.UpdateMonsterRequestDTO;
import com.petreca.bestiaryandarmory.monster.mapper.MonsterMapper;
import com.petreca.bestiaryandarmory.monster.model.Monster;
import com.petreca.bestiaryandarmory.monster.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonsterService {

    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;

    public List<MonsterDTO> getAllMonsters() {
        return monsterRepository.findAll()
                .stream()
                .map(monsterMapper::toDTO)
                .toList();
    }

    public Optional<MonsterDTO> getMonsterById(Long id) {
        return monsterRepository.findById(id)
                .map(monsterMapper::toDTO);
    }

    public MonsterDTO createMonster(CreateMonsterRequestDTO requestDTO) {
        Monster monster = new Monster();
        monster.setName(requestDTO.getName());
        monster.setDescription(requestDTO.getDescription());
        monster.setMonsterType(requestDTO.getMonsterType());
        monster.setWeakness(requestDTO.getWeakness());
        monster.setHabitat(requestDTO.getHabitat());
        monster.setDangerLevel(requestDTO.getDangerLevel());
        Monster savedMonster = monsterRepository.save(monster);
        return monsterMapper.toDTO(savedMonster);
    }

    public Optional<MonsterDTO> updateMonster(Long id, UpdateMonsterRequestDTO requestDTO) {
        return monsterRepository.findById(id)
                .map(existingMonster -> {
                    existingMonster.setName(requestDTO.getName());
                    existingMonster.setDescription(requestDTO.getDescription());
                    existingMonster.setMonsterType(requestDTO.getMonsterType());
                    existingMonster.setWeakness(requestDTO.getWeakness());
                    existingMonster.setHabitat(requestDTO.getHabitat());
                    existingMonster.setDangerLevel(requestDTO.getDangerLevel());
                    return monsterMapper.toDTO(monsterRepository.save(existingMonster));
                });
    }

    public boolean deleteMonster(Long id) {
        if (monsterRepository.existsById(id)) {
            monsterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}