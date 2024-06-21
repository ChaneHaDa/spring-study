package com.chan.spring_jpa.jpa.repository;

import com.chan.spring_jpa.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
