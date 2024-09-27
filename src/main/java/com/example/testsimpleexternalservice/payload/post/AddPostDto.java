package com.example.testsimpleexternalservice.payload.post;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPostDto {
    String title;
    String content;
}
