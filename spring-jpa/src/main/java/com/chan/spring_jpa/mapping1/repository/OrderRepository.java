package com.chan.spring_jpa.mapping1.repository;

import com.chan.spring_jpa.mapping1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
