package com.chan.springjpanm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_hashtag")
    private Set<Hashtag> hashtags = new HashSet<>();
}
