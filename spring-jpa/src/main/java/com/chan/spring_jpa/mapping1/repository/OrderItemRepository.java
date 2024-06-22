package com.chan.spring_jpa.mapping1.repository;

import com.chan.spring_jpa.mapping1.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
