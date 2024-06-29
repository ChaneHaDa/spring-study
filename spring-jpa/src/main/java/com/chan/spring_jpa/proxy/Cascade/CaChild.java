package com.chan.spring_jpa.proxy.Cascade;

import jakarta.persistence.*;

// Cascade
@Entity
public class CaChild {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CaParent parent;
}
