package com.chan.springjpanm.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PostIdentityInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_identity_info_tag_identity_info",
            joinColumns = @JoinColumn(name = "post_identity_info_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_identity_info_id")
    )
    @Builder.Default
    private Set<TagIdentityInfo> tags = new HashSet<>();
}
