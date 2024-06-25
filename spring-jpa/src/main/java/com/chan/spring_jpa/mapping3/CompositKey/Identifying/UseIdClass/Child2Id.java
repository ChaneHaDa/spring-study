package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseIdClass;

import java.io.Serializable;

// 복합 키 식별 관계 매핑 IdClass 사용
public class Child2Id implements Serializable {
    private String parent;
    private String childId;

    public Child2Id() {
    }

    public Child2Id(String parent, String childId) {
        this.parent = parent;
        this.childId = childId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child2Id child2Id = (Child2Id) o;
        return parent.equals(child2Id.parent) && childId.equals(child2Id.childId);
    }

    @Override
    public int hashCode() {
        return parent.hashCode() + childId.hashCode();
    }
}
