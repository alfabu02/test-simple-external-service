package com.example.testsimpleexternalservice.repository;

import com.example.testsimpleexternalservice.document.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, String> {

    Page<Comment> findByPostIdAndTextContainingIgnoreCase(String postId, String text, Pageable pageable);

    Optional<Comment> findByIdAndUserId(String id, String userId);

    boolean existsByIdAndUserId(String id, String userId);
}
