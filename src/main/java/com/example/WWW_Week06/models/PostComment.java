package com.example.WWW_Week06.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class PostComment {
    @Id
    @Column(columnDefinition = "bigint(20)")
    private long id;
    @Column(columnDefinition = "tinytext")
    private String content;
    @Column(name = "created_at", columnDefinition = "datetime(6)")
    private Instant createdAt;
    @Column(columnDefinition = "bit(1)")
    private boolean published;
    @Column(name = "published_at", columnDefinition = "datetime(6)")
    private Instant publishedAt;
    @Column(columnDefinition = "varchar(100)")
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parent;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
