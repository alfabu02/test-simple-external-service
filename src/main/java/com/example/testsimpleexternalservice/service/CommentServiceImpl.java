package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.document.Comment;
import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.exception.MyNotFoundException;
import com.example.testsimpleexternalservice.mapper.CommentMapper;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.comment.AddCommentDto;
import com.example.testsimpleexternalservice.payload.comment.CommentDto;
import com.example.testsimpleexternalservice.payload.comment.EditCommentDto;
import com.example.testsimpleexternalservice.repository.CommentRepository;
import com.example.testsimpleexternalservice.repository.PostRepository;
import com.example.testsimpleexternalservice.util.PrincipalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;

    @Override
    public ApiResponse<CommentDto> getCommentById(String id) {
        return null;
    }

    @Override
    public ApiResponse<PageDto<CommentDto>> getAllCommentsByPostId(String postId, int page, int size, String search) {
        Page<Comment> postsPage = commentRepository.findByPostIdAndTextContainingIgnoreCase(postId, search, PageRequest.of(page, size));

        PageDto<CommentDto> pageDto = PageDto.fromPage(postsPage);

        List<Comment> content = postsPage.getContent();
        List<CommentDto> commentDtoList = commentMapper.toDtoList(content);
        pageDto.setContent(commentDtoList);

        return ApiResponse.success(pageDto);
    }

    @Override
    public ApiResponse<CommentDto> createComment(AddCommentDto addCommentDto) {
        String postId = addCommentDto.postId();
        if (!postRepository.existsById(postId))
            throw new MyNotFoundException("Post not found by id, postId = " + postId);

        Comment comment = commentMapper.toDocument(addCommentDto);
        commentRepository.save(comment);

        CommentDto commentDto = commentMapper.toDto(comment);
        return ApiResponse.success(commentDto);
    }

    @Override
    public ApiResponse<CommentDto> editeComment(String id, EditCommentDto editCommentDto) {
        User user = PrincipalUtil.getCurrentUser();

        Comment comment = commentRepository.findByIdAndUserId(id, user.getId()).orElseThrow(() -> new MyNotFoundException("Comment not found by id, id = " + id));

        comment.setText(editCommentDto.getText());
        commentRepository.save(comment);

        CommentDto commentDto = commentMapper.toDto(comment);
        return ApiResponse.success(commentDto);
    }

    @Override
    public void deleteComment(String id) {
        User user = PrincipalUtil.getCurrentUser();

        boolean exists = commentRepository.existsByIdAndUserId(id, user.getId());
        if (!exists)
            throw new MyNotFoundException("Comment not found by id, id = " + id);

        commentRepository.deleteById(id);
    }
}
