package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// 다대다 단방향
@Entity
public class Member7 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER7_PRODUCT7",
            joinColumns = @JoinColumn(name = "MEMBER7_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT7_ID"))
    private List<Product7> products = new ArrayList<>();
}
