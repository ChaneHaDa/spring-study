package com.chan.spring_jpa.proxy.Loading;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Lazy, Eager Loading
@Entity
public class LoOrders {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;
}
