package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.constant.PathConstant;
import com.example.testsimpleexternalservice.payload.PageDto;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.comment.AddCommentDto;
import com.example.testsimpleexternalservice.payload.comment.CommentDto;
import com.example.testsimpleexternalservice.payload.comment.EditCommentDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(PathConstant.CommentPathConstant.BASE_PATH)
public interface CommentController {

    @Operation(summary = "Get one comment by it's id")
    @GetMapping(PathConstant.SLASH_ID)
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<CommentDto> getCommentById(@PathVariable String id);

    @Operation(summary = "Get all comments of post by filter")
    @GetMapping(PathConstant.CommentPathConstant.BY_POST_ID)
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<PageDto<CommentDto>> getAllCommentsByPostId(@PathVariable String postId,
                                                            @RequestParam(required = false, defaultValue = "0") int page,
                                                            @RequestParam(required = false, defaultValue = "10") int size,
                                                            @RequestParam(required = false, defaultValue = "") String search);

    @Operation(summary = "Add comment to post")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<CommentDto> createComment(@Valid @RequestBody AddCommentDto addCommentDto);

    @Operation(summary = "Edit comment by id")
    @PutMapping(PathConstant.SLASH_ID)
    @ResponseStatus(HttpStatus.ACCEPTED)
    ApiResponse<CommentDto> editeComment(@PathVariable String id, @Valid @RequestBody EditCommentDto editCommentDto);

    @Operation(summary = "Delete comment by id")
    @DeleteMapping(PathConstant.SLASH_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteComment(@PathVariable String id);
}
