package com.chan.springjpanm.controller;

import com.chan.springjpanm.dto.PostDto;
import com.chan.springjpanm.dto.TagDto;
import com.chan.springjpanm.model.*;
import com.chan.springjpanm.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/many-to-many3")
public class ManytoMany3Controller {

    private final Post2Repository post2Repository;
    private final PostPlainRepository postPlainRepository;
    private final PostJsonIgnoreRepository postJsonIgnoreRepository;
    private final PostIdentityInfoRepository postIdentityInfoRepository;

    public ManytoMany3Controller(Post2Repository post2Repository, PostPlainRepository postPlainRepository, PostJsonIgnoreRepository postJsonIgnoreRepository, PostIdentityInfoRepository postIdentityInfoRepository) {
        this.post2Repository = post2Repository;
        this.postPlainRepository = postPlainRepository;
        this.postJsonIgnoreRepository = postJsonIgnoreRepository;
        this.postIdentityInfoRepository = postIdentityInfoRepository;
    }

    // 1. 순환 참조가 발생하는 엔드포인트
    @GetMapping("/plain")
    public PostPlain getPostPlain() {
        if (postPlainRepository.count() == 0) {
            TagPlain tag1 = TagPlain.builder().name("Spring Boot 3").build();
            TagPlain tag2 = TagPlain.builder().name("JPA Hibernate").build();
            Set<TagPlain> tags = new HashSet<>(Set.of(tag1, tag2));
            PostPlain post = PostPlain.builder()
                    .title("JPA N:M Relationship Guide")
                    .content("A guide on handling Many-to-Many relationships and serialization issues.")
                    .tags(tags)
                    .build();
            postPlainRepository.save(post);
        }
        return postPlainRepository.findAll().get(0);
    }

    // 2. @JsonIgnore를 사용한 엔드포인트
    @GetMapping("/json-ignore")
    public PostJsonIgnore getPostJsonIgnore() {
        if (postJsonIgnoreRepository.count() == 0) {
            TagJsonIgnore tag1 = TagJsonIgnore.builder().name("Spring Boot 3").build();
            TagJsonIgnore tag2 = TagJsonIgnore.builder().name("JPA Hibernate").build();
            Set<TagJsonIgnore> tags = new HashSet<>(Set.of(tag1, tag2));
            PostJsonIgnore post = PostJsonIgnore.builder()
                    .title("JPA N:M Relationship Guide")
                    .content("A guide on handling Many-to-Many relationships and serialization issues.")
                    .tags(tags)
                    .build();
            postJsonIgnoreRepository.save(post);
        }
        return postJsonIgnoreRepository.findAll().get(0);
    }

    // 3. @JsonManagedReference / @JsonBackReference를 사용한 엔드포인트
    @GetMapping("/managed-back-reference")
    public Post2 getPostWithManagedBackReference() {
        if (post2Repository.count() == 0) {
            Tag2 tag1 = Tag2.builder().name("Spring Boot 3").build();
            Tag2 tag2 = Tag2.builder().name("JPA Hibernate").build();
            Set<Tag2> tags = new HashSet<>(Set.of(tag1, tag2));
            Post2 post = Post2.builder()
                    .title("JPA N:M Relationship Guide")
                    .content("A guide on handling Many-to-Many relationships and serialization issues.")
                    .tags(tags)
                    .build();
            post2Repository.save(post);
        }
        return post2Repository.findAll().get(0);
    }

    // 4. @JsonIdentityInfo를 사용한 엔드포인트
    @GetMapping("/identity-info")
    public PostIdentityInfo getPostWithIdentityInfo() {
        if (postIdentityInfoRepository.count() == 0) {
            TagIdentityInfo tag1 = TagIdentityInfo.builder().name("Spring Boot 3").build();
            TagIdentityInfo tag2 = TagIdentityInfo.builder().name("JPA Hibernate").build();
            Set<TagIdentityInfo> tags = new HashSet<>(Set.of(tag1, tag2));
            PostIdentityInfo post = PostIdentityInfo.builder()
                    .title("JPA N:M Relationship Guide")
                    .content("A guide on handling Many-to-Many relationships and serialization issues.")
                    .tags(tags)
                    .build();
            postIdentityInfoRepository.save(post);
        }
        return postIdentityInfoRepository.findAll().get(0);
    }

    // 5. DTO를 사용한 엔드포인트
    @GetMapping("/dto")
    public PostDto getPostDto() {
        if (postPlainRepository.count() == 0) {
            TagPlain tag1 = TagPlain.builder().name("Spring Boot 3").build();
            TagPlain tag2 = TagPlain.builder().name("JPA Hibernate").build();
            Set<TagPlain> tags = new HashSet<>(Set.of(tag1, tag2));
            PostPlain post = PostPlain.builder()
                    .title("JPA N:M Relationship Guide")
                    .content("A guide on handling Many-to-Many relationships and serialization issues.")
                    .tags(tags)
                    .build();
            postPlainRepository.save(post);
        }
        PostPlain post = postPlainRepository.findAll().get(0);
        return toDto(post);
    }

    private PostDto toDto(PostPlain post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .tags(post.getTags().stream().map(this::toDto).collect(Collectors.toSet()))
                .build();
    }

    private TagDto toDto(TagPlain tag) {
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
