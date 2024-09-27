package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.post.AddPostDto;
import com.example.testsimpleexternalservice.payload.post.PostDto;
import com.example.testsimpleexternalservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostControllerImpl implements PostController {
    private final PostService postService;

    @Override
    public ApiResponse<PostDto> createPost(AddPostDto addPostDto) {
        return postService.createPost(addPostDto);
    }

    @Override
    public ApiResponse<PageDto<PostDto>> getPosts(int size, int page, String search) {
        return postService.getPosts(size, page, search);
    }

    @Override
    public ApiResponse<List<PostDto>> getPostsByUserId(String userId) {
        return postService.getPostsByUserId(userId);
    }
}
