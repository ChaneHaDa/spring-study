package com.chan.springjpanm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Post2 {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post2_tag2",
            joinColumns = @JoinColumn(name = "post2_id"),
            inverseJoinColumns = @JoinColumn(name = "tag2_id")
    )
    @Builder.Default
    @JsonManagedReference
    private Set<Tag2> tags = new HashSet<>();
}
