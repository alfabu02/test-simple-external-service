package com.example.testsimpleexternalservice.document;

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
@Document("posts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post extends AbsTimeDocument{
    @Id
    String id;
    String title;
    String content;
    @CreatedBy
    String userId;
}
