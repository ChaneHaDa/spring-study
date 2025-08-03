package com.chan.springjpanm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Set<TagDto> tags;
}
