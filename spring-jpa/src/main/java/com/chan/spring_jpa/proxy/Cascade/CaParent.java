package com.chan.spring_jpa.proxy.Cascade;

import jakarta.persistence.*;

import java.util.List;

// Cascade
@Entity
public class CaParent {
    @Id
    @GeneratedValue
    private Long id;

    // CascadeType: ALL, PERSIST, REMOVE, MERGE, REFRESH, DETACH / 영속성 전이
    // @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    // 부모가 없는 자식은 삭제
    // @OneToMany(mappedBy = "parent", orphanRemoval = true)
    // CascadeType.ALL + orphanRemoval = true -> 부모 엔티티를 통해서 생명주기를 관리가 가능
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaChild> children;
}
