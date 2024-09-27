package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.document.Post;
import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.mapper.PostMapper;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.post.AddPostDto;
import com.example.testsimpleexternalservice.payload.post.PostDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import com.example.testsimpleexternalservice.repository.PostRepository;
import com.example.testsimpleexternalservice.util.PrincipalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public ApiResponse<PostDto> createPost(AddPostDto addPostDto) {
        Post post = postMapper.toDocument(addPostDto);

        postRepository.save(post);

        PostDto postDto = postMapper.toDto(post);

        return ApiResponse.successWithMessage(postDto, "Post created!");
    }

    @Override
    public ApiResponse<PageDto<PostDto>> getPosts(int size, int page, String search) {
        Page<Post> postsPage = postRepository.searchPosts(search, PageRequest.of(page, size));

        PageDto<PostDto> pageDto = PageDto.fromPage(postsPage);

        List<Post> content = postsPage.getContent();
        List<PostDto> postDtoList = postMapper.toDtoList(content);
        pageDto.setContent(postDtoList);

        return ApiResponse.success(pageDto);
    }

    @Override
    public ApiResponse<List<PostDto>> getPostsByUserId(String userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        List<PostDto> postDtoList = postMapper.toDtoList(posts);
        return ApiResponse.success(postDtoList);
    }
}
