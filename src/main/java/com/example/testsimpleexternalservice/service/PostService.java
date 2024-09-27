package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.post.AddPostDto;
import com.example.testsimpleexternalservice.payload.post.PostDto;

import java.util.List;

public interface PostService {

    ApiResponse<PostDto> createPost(AddPostDto addPostDto);

    ApiResponse<PageDto<PostDto>> getPosts(int size, int page, String search);

    ApiResponse<List<PostDto>> getPostsByUserId(String userId);
}
