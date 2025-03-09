package com.chan.springjpanm.controller;

import com.chan.springjpanm.model.*;
import com.chan.springjpanm.repository.Hashtag1Repository;
import com.chan.springjpanm.repository.HashtagRepository;
import com.chan.springjpanm.repository.Post1Repository;
import com.chan.springjpanm.repository.PostHashtagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("api/v1/many-to-many2")
public class ManytoMany2Controller {
    private final PostHashtagRepository postHashtagRepository;
    private final Post1Repository post1Repository;
    private final Hashtag1Repository hashtag1Repository;

    public ManytoMany2Controller(PostHashtagRepository postHashtagRepository, Post1Repository post1Repository, Hashtag1Repository hashtag1Repository) {
        this.postHashtagRepository = postHashtagRepository;
        this.post1Repository = post1Repository;
        this.hashtag1Repository = hashtag1Repository;
    }

    @PostMapping("/save")
    public Post1 saveManytoMany2() {
        Post1 post1 = Post1.builder()
                .title("title")
                .content("content")
                .build();
        Post1 savedPost = post1Repository.save(post1);

        Hashtag1 hashtag1 = Hashtag1.builder().name("tag1").count(1L).build();
        Hashtag1 hashtag2 = Hashtag1.builder().name("tag2").count(1L).build();
        Hashtag1 hashtag3 = Hashtag1.builder().name("tag3").count(1L).build();
        Hashtag1 hashtag4 = Hashtag1.builder().name("tag4").count(1L).build();
        Hashtag1 hashtag5 = Hashtag1.builder().name("tag5").count(1L).build();

        Hashtag1 savedHashtag1 = hashtag1Repository.save(hashtag1);
        Hashtag1 savedHashtag2 = hashtag1Repository.save(hashtag2);
        Hashtag1 savedHashtag3 = hashtag1Repository.save(hashtag3);
        Hashtag1 savedHashtag4 = hashtag1Repository.save(hashtag4);
        Hashtag1 savedHashtag5 = hashtag1Repository.save(hashtag5);

        savedPost.addHashtag(savedHashtag1);
        savedPost.addHashtag(savedHashtag2);
        savedPost.addHashtag(savedHashtag3);
        savedPost.addHashtag(savedHashtag4);
        savedPost.addHashtag(savedHashtag5);

        Post1 updatedPost = post1Repository.save(savedPost);

        return updatedPost;
    }

    @GetMapping("/find")
    public Post1 findManytoMany2() {
        Post1 savedPost = post1Repository.findAll().get(0);
        return savedPost;
    }

    @GetMapping("/update")
    public Post1 updateManytoMany2() {
        Post1 savedPost = post1Repository.findAll().get(0);
        for(PostHashtag ph:savedPost.getPostHashtags()){
            ph.getHashtag().setName(ph.getHashtag().getName() + " updated");
            System.out.println(ph.getHashtag().getName());
        }
        Post1 updatedPost = post1Repository.save(savedPost);

        return updatedPost;
    }
    
    @GetMapping("/delete")
    public Post1 deleteManytoMany2() {
        Post1 savedPost = post1Repository.findAll().get(0);
        Hashtag1 hashtag1 = hashtag1Repository.findAll().get(0);
        savedPost.removeHashtag(hashtag1);
        post1Repository.save(savedPost);

        return post1Repository.findAll().get(0);
    }

}
