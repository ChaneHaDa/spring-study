package com.chan.query.entity;

import com.chan.query.value.Address;
import jakarta.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;
    @Embedded private Address address;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Member member;

    public Orders() {
    }
}
