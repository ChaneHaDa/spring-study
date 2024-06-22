package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 일대다 단방향
@Entity
public class Member3 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
}
