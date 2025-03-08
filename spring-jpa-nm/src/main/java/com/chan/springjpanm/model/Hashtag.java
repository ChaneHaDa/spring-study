package com.chan.springjpanm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long count;

    @ManyToMany(mappedBy = "hashtags")
    @JsonIgnore
    private Set<Post> posts = new HashSet<>();

}
