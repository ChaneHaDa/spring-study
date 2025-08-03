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
public class PostPlain {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_plain_tag_plain",
            joinColumns = @JoinColumn(name = "post_plain_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_plain_id")
    )
    @Builder.Default
    private Set<TagPlain> tags = new HashSet<>();
}
