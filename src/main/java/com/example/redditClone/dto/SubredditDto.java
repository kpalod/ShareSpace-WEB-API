package com.example.redditClone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder

public class SubredditDto {
    private Long id;
    private String name;
    private String description;
    private Integer numberOfPosts;

}
