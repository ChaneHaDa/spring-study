package com.chan.spring_jpa.jpa.repository;

import com.chan.spring_jpa.jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
