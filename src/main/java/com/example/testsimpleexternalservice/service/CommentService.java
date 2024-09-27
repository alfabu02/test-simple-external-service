package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.comment.AddCommentDto;
import com.example.testsimpleexternalservice.payload.comment.CommentDto;
import com.example.testsimpleexternalservice.payload.comment.EditCommentDto;

public interface CommentService {

    ApiResponse<CommentDto> getCommentById(String id);

    ApiResponse<PageDto<CommentDto>> getAllCommentsByPostId(String postId, int page, int size, String search);

    ApiResponse<CommentDto> createComment(AddCommentDto addCommentDto);

    ApiResponse<CommentDto> editeComment(String id, EditCommentDto editCommentDto);

    void deleteComment(String id);
}
