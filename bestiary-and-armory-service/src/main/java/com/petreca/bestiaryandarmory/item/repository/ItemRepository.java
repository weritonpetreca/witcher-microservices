package com.petreca.bestiaryandarmory.item.repository;

import com.petreca.bestiaryandarmory.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
