package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// 다대다 연결엔티티 활용
@Entity
public class Member8 {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "member8")
    private List<MemberProduct8> memberProducts;
}
