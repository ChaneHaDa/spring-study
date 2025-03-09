package com.chan.springjpanm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post1 {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<PostHashtag> postHashtags = new HashSet<>();

    // 연관관계 편의 메서드: 해시태그 추가
    public void addHashtag(Hashtag1 hashtag) {
        PostHashtag postHashtag = new PostHashtag(this, hashtag);
        postHashtags.add(postHashtag);
//        hashtag.getPostHashtags().add(postHashtag);
    }

    // 연관관계 편의 메서드: 해시태그 제거
    public void removeHashtag(Hashtag1 hashtag) {
        for (Iterator<PostHashtag> iterator = postHashtags.iterator(); iterator.hasNext(); ) {
            PostHashtag postHashtag = iterator.next();
            if (postHashtag.getPost().equals(this) && postHashtag.getHashtag().equals(hashtag)) {
                iterator.remove();
                hashtag.getPostHashtags().remove(postHashtag);
                postHashtag.setPost(null);
                postHashtag.setHashtag(null);
            }
        }
    }
}
