package com.example.testsimpleexternalservice.document;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document("comments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment extends AbsTimeDocument{
    @Id
    String id;
    String text;
    String postId;
    @CreatedBy
    String userId;
}
