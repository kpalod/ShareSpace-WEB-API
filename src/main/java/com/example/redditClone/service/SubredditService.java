package com.example.redditClone.service;

import com.example.redditClone.dto.SubredditDto;
import com.example.redditClone.model.Subreddit;
import com.example.redditClone.repository.SubredditRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j

public class SubredditService {

    private final SubredditRepository subredditRepository;
    @Transactional
    public SubredditDto save(SubredditDto subredditDto){
        Subreddit save = subredditRepository.save(mapSubredditDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }
    @Transactional
    public List<SubredditDto> getAll(){
        return subredditRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    private Subreddit mapSubredditDto(SubredditDto subredditDto){
        return Subreddit.builder()
                .name(subredditDto.getName())
                .description(subredditDto.getDescription())
                .build();
    }

    private SubredditDto mapToDto(Subreddit subreddit){
        return SubredditDto.builder()
                .name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }


}
