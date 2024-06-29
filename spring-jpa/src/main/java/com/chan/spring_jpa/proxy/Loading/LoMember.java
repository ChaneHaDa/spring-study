package com.chan.spring_jpa.proxy.Loading;

import jakarta.persistence.*;

import java.util.List;

// Lazy, Eager Loading
@Entity
public class LoMember {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOTEAM_ID", nullable = false) // 내부 조인을 사용
    private LoTeam team;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<LoOrders> orders;
}
