package com.example.testsimpleexternalservice.repository;

import com.example.testsimpleexternalservice.document.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    Page<Post> findByTitleOrContent(String title, String content, Pageable pageable);

    default Page<Post> searchPosts(String search, Pageable pageable) {
        return findByTitleOrContent(search, search, pageable);
    }

    List<Post> findByUserId(String userId);

}
