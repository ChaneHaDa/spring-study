package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseIdClass;

import java.io.Serializable;
import java.util.Objects;

// 복합 키 식별 관계 매핑 IdClass 사용
public class GrandChild2Id implements Serializable {

    private Child2Id child;
    private String id;

    public GrandChild2Id() {
    }

    public GrandChild2Id(Child2Id child, String id) {
        this.child = child;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrandChild2Id that = (GrandChild2Id) o;
        return Objects.equals(child, that.child) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child, id);
    }
}
