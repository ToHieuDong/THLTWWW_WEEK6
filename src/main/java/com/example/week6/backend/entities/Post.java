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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint(20)", nullable = false)
    private long id;
    @Column(name = "publishes", columnDefinition = "tinyint(1)", nullable = false)
    private boolean publishes;
    @Column(name = "content", columnDefinition = "text", nullable = false)
    private String content;
    @Column(name = "meta_title", length = 100, nullable = false)
    private String metaTitle;
    @Column(name = "summary", columnDefinition = "tinytext", nullable = false)
    private String summary;
    @Column(name = "title", length = 75, nullable = false)
    private String title;
    @Column(name = "created_at", columnDefinition = "datetime", nullable = false)
    private LocalDate createdAt;
    @Column(name = "updated_at", columnDefinition = "datetime", nullable = false)
    private LocalDate updatedAt;
    @Column(name = "published_at", columnDefinition = "datetime", nullable = false)
    private LocalDate publishedAt;

    public Post(boolean publishes, String content, String metaTitle, String summary, String title, LocalDate createdAt, LocalDate updatedAt, LocalDate publishedAt) {
        this.publishes = publishes;
        this.content = content;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }

    public Post(boolean publishes, String content, String metaTitle, String summary, String title, LocalDate createdAt, LocalDate updatedAt, LocalDate publishedAt, User author) {
        this.publishes = publishes;
        this.content = content;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.author = author;
    }

    //========================
//    @OneToMany(mappedBy = "id")
//    private Set<PostComment> postComments;
//    @OneToMany(mappedBy = "parent_id")
//    private Set<Post> posts;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Post parent;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;


}
