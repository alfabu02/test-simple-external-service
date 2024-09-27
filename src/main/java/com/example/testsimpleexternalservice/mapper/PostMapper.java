package com.example.testsimpleexternalservice.mapper;

import com.example.testsimpleexternalservice.document.Post;
import com.example.testsimpleexternalservice.payload.post.AddPostDto;
import com.example.testsimpleexternalservice.payload.post.PostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toDocument(AddPostDto addPostDto);

    PostDto toDto(Post post);

    List<PostDto> toDtoList(List<Post> posts);

}
