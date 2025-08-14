package com.petreca.bestiaryandarmory.monster.repository;

import com.petreca.bestiaryandarmory.monster.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
}