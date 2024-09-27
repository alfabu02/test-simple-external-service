package com.example.testsimpleexternalservice.payload.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditCommentDto {
    @NotBlank(message = "text is required!")
    String text;
}
