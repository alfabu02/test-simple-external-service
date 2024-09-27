package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.constant.PathConstant;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.post.AddPostDto;
import com.example.testsimpleexternalservice.payload.post.PostDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(PathConstant.PostPathConstant.BASE_PATH)
public interface PostController {

    @PostMapping
    ApiResponse<PostDto> createPost(@Valid @RequestBody AddPostDto addPostDto);

    @GetMapping
    ApiResponse<PageDto<PostDto>> getPosts(@RequestParam(required = false, defaultValue = "10") int size,
                                           @RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "") String search);

    @GetMapping("/by-user-id/{userId}")
    ApiResponse<List<PostDto>> getPostsByUserId(@PathVariable("userId") String userId);

}
