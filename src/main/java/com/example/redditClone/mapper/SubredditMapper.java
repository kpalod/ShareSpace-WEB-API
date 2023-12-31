package com.example.redditClone.mapper;

import com.example.redditClone.dto.SubredditDto;
import com.example.redditClone.model.Post;
import com.example.redditClone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {
    @Mapping(target = "numberOfPosts", expression ="java(mapPosts(subreddit.getPosts()))" )
    SubredditDto mapSubredditToDto(Subreddit subreddit);
    default Integer mapPosts(List<Post> numberOfPosts){
        return numberOfPosts.size();
    }
    @InheritInverseConfiguration
    @Mapping(target = "posts" , ignore = true)
    Subreddit mapDtotoSubreddit(SubredditDto subredditDto);

}
