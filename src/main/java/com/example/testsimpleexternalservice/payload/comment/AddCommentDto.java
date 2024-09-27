package com.example.testsimpleexternalservice.payload.comment;

import jakarta.validation.constraints.NotBlank;

public record AddCommentDto(@NotBlank(message = "text is required!")
                            String text,
                            @NotBlank(message = "postId is required!")
                            String postId) {
}
