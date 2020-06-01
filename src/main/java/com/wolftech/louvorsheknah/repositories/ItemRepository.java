package com.wolftech.louvorsheknah.repositories;

import com.wolftech.louvorsheknah.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNomeContainsIgnoreCase(String nome);

    Item findByNome(String nome);
}

