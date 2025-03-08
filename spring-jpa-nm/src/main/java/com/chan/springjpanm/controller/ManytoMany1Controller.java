package com.chan.springjpanm.controller;

import com.chan.springjpanm.model.Hashtag;
import com.chan.springjpanm.model.Post;
import com.chan.springjpanm.repository.HashtagRepository;
import com.chan.springjpanm.repository.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/many-to-many1")
public class ManytoMany1Controller {

    private final HashtagRepository hashtagRepository;
    private final PostRepository postRepository;

    public ManytoMany1Controller(HashtagRepository hashtagRepository, PostRepository postRepository) {
        this.hashtagRepository = hashtagRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/insert")
    public Post insertManyToMany1() {
        Hashtag hashtag1 = Hashtag.builder()
                .name("SpringBoot")
                .count(120L)
                .build();

        Hashtag hashtag2 = Hashtag.builder()
                .name("Java")
                .count(200L)
                .build();

        Hashtag hashtag3 = Hashtag.builder()
                .name("JPA")
                .count(150L)
                .build();

        Hashtag hashtag4 = Hashtag.builder()
                .name("Backend")
                .count(80L)
                .build();

        Hashtag hashtag5 = Hashtag.builder()
                .name("Database")
                .count(95L)
                .build();
        Set<Hashtag> hashtags = new HashSet<>(Set.of(hashtag1, hashtag2, hashtag3, hashtag4, hashtag5));

        Post post1 = Post.builder()
                .title("title1")
                .content("content")
                .hashtags(hashtags)
                .build();

        Post savedPost = postRepository.save(post1);

        return savedPost;
    }

    @PostMapping("/update")
    public Post updateManyToMany1() {
        Post post = postRepository.findAll().get(0);

        for(Hashtag hashtag : post.getHashtags()) {
            hashtag.setName(hashtag.getName()+"updated");
        }

        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @PostMapping("/insert-hashtag")
    public Post insertHashtag() {
        Post post = postRepository.findAll().get(0);
        Hashtag hashtag = Hashtag.builder()
                .name("insertName")
                .count(9L)
                .build();

        // hashtag를 먼저 영속화해야 저장 가능
        hashtagRepository.save(hashtag);
        post.getHashtags().add(hashtag);

        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @PostMapping("/delete")
    public String deleteManyToMany1() {
        Post post = postRepository.findAll().get(0);
        postRepository.delete(post);
        return "deleted";
    }

}
