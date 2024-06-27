package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseIdClass;

import jakarta.persistence.*;

// 복합 키 식별 관계 매핑 IdClass 사용
@Entity
@IdClass(Child2Id.class)
public class Child2 {

        @Id
        @ManyToOne
        @JoinColumn(name = "parent2_id")
        public Parent2 parent;
        @Id
        private String childId;
        private String name;

        public Child2() {
        }
}
