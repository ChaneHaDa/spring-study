package com.chan.spring_jpa.mapping3.CompositKey.Identifying.OneToOne;

import jakarta.persistence.*;

@Entity
public class BoardDetail {
    @Id
    private Long boardId;
    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    private String content;
}
