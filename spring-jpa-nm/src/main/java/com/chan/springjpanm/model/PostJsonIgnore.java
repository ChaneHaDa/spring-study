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
public class PostJsonIgnore {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_json_ignore_tag_json_ignore",
            joinColumns = @JoinColumn(name = "post_json_ignore_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_json_ignore_id")
    )
    @Builder.Default
    private Set<TagJsonIgnore> tags = new HashSet<>();
}
