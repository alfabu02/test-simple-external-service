package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.comment.AddCommentDto;
import com.example.testsimpleexternalservice.payload.comment.CommentDto;
import com.example.testsimpleexternalservice.payload.comment.EditCommentDto;
import com.example.testsimpleexternalservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    @Override
    public ApiResponse<CommentDto> getCommentById(String id) {
        return commentService.getCommentById(id);
    }

    @Override
    public ApiResponse<PageDto<CommentDto>> getAllCommentsByPostId(String postId, int page, int size, String search) {
        return commentService.getAllCommentsByPostId(postId, page, size, search);
    }

    @Override
    public ApiResponse<CommentDto> createComment(AddCommentDto addCommentDto) {
        return commentService.createComment(addCommentDto);
    }

    @Override
    public ApiResponse<CommentDto> editeComment(String id, EditCommentDto editCommentDto) {
        return commentService.editeComment(id, editCommentDto);
    }

    @Override
    public void deleteComment(String id) {
        commentService.deleteComment(id);
    }
}
