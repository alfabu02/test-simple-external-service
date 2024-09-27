package com.example.testsimpleexternalservice.payload.comment;

import com.example.testsimpleexternalservice.payload.user.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDto {
    String id;
    String text;
    String postId;
    String userId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
