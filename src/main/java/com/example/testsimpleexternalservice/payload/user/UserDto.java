package com.example.testsimpleexternalservice.payload.user;

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
public class UserDto {
    String id;
    String firstName;
    String lastName;
    String imageUrl;
    String email;
    String password;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
