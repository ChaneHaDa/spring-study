package com.chan.spring_jpa.mapping3.Inheritance.NoTable;

import jakarta.persistence.Entity;

// MappedSuperclass의 사용
@Entity
public class ESeller extends BaseEntity {
    private String shopName;
}
