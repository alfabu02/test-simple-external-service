package com.example.testsimpleexternalservice.document;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document("users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbsTimeDocument {
    @Id
    String id;
    String firstName;
    String lastName;
    String email;
    String password;
    String imageUrl;
    boolean enabled;
}
