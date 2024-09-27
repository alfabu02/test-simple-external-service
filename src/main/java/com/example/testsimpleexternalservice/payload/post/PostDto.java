package com.example.testsimpleexternalservice.payload.post;

import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {
    String id;
    String title;
    String content;
    String userId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
