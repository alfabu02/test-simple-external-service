package com.example.testsimpleexternalservice.mapper;

import com.example.testsimpleexternalservice.document.Comment;
import com.example.testsimpleexternalservice.payload.comment.AddCommentDto;
import com.example.testsimpleexternalservice.payload.comment.CommentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toDocument(AddCommentDto addCommentDto);

    CommentDto toDto(Comment comment);

    List<CommentDto> toDtoList(List<Comment> comments);

}
