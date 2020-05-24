package com.wolftech.louvorsheknah.repositories;

import com.wolftech.louvorsheknah.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}