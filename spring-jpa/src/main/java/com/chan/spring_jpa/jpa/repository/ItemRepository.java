package com.chan.spring_jpa.jpa.repository;

import com.chan.spring_jpa.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
