package com.chan.spring_jpa.mapping1.repository;

import com.chan.spring_jpa.mapping1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
