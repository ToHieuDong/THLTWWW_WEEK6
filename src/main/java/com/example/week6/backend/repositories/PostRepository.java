package com.example.week6.backend.repositories;

import com.example.week6.backend.entities.Post;
import com.example.week6.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorId(Long user);
}
