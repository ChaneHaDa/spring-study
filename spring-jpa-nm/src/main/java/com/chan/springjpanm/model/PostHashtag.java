package com.chan.springjpanm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = {"post", "hashtag"})
public class PostHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post1 post;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag1 hashtag;

    public PostHashtag(Post1 post, Hashtag1 hashtag) {
        this.post = post;
        this.hashtag = hashtag;
    }
}
