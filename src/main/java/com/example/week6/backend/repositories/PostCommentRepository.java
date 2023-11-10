package com.example.week6.backend.repositories;

import com.example.week6.backend.entities.Post;
import com.example.week6.backend.entities.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findAllByPostId(Long postId);

}
