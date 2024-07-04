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

    public Orders(int orderAmount, Address address) {
        this.orderAmount = orderAmount;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public Address getAddress() {
        return address;
    }

    public Product getProduct() {
        return product;
    }

    public Member getMember() {
        return member;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
