package com.chan.spring_jpa.mapping3.CompositKey.Identifying.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// 일대일 식별 관계
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;

    public Board() {
    }

    public Board(String title) {
        this.title = title;
    }

}
