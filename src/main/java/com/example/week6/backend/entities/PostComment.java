package com.example.week6.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postcmt_id", columnDefinition = "bigint(20)", nullable = false)
    private long id;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "publishes", columnDefinition = "tinyint(1)", nullable = false)
    private boolean publishes;
    @Column(name = "content", columnDefinition = "text", nullable = false)
    private String content;
    @Column(name = "created_at", columnDefinition = "datetime", nullable = false)
    private LocalDate createdAt;
    @Column(name = "published_at", columnDefinition = "datetime", nullable = false)
    private LocalDate publishedAt;
//================================================
//    @OneToMany(mappedBy = "postcmt_id")
//    private Set<PostComment> postComments;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private PostComment posts;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PostComment(String title, boolean publishes, String content, LocalDate createdAt, LocalDate publishedAt, Post post, User user) {
        this.title = title;
        this.publishes = publishes;
        this.content = content;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.post = post;
        this.user = user;
    }
}
