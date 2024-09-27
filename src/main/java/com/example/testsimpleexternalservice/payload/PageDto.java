package com.example.testsimpleexternalservice.payload;

import com.example.testsimpleexternalservice.document.Post;
import com.example.testsimpleexternalservice.payload.post.PostDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageDto<T> {
    long totalElements;
    int totalPages;
    int size;
    int page;
    int numberOfElements;
    boolean first;
    boolean last;
    List<T> content;

    public static <T1, T2> PageDto<T1> fromPage(Page<T2> postsPage) {
        return PageDto.<T1>builder()
                .totalElements(postsPage.getTotalElements())
                .totalPages(postsPage.getTotalPages())
                .page(postsPage.getNumber())
                .size(postsPage.getSize())
                .first(postsPage.isFirst())
                .last(postsPage.isLast())
                .numberOfElements(postsPage.getNumberOfElements())
                .build();
    }
}
