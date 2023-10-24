package com.example.WWW_Week06.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Data
public class Post {
    @Id
    @Column(columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "tinytext")
    private String content;
    @Column(name = "create_at", columnDefinition = "datetime(6)")
    private Date createAt;
    @Column(name = "meta_title", columnDefinition = "varchar(100)")
    private String metaTitle;
    @Column(columnDefinition = "bit(1)")
    private boolean published;
    @Column(name = "publish_at",columnDefinition = "datetime(6)")
    private Instant publishedAt;

    @Lob
    @Column(columnDefinition = "tinytext")
    private String summary;
    @Column(columnDefinition = "varchar(75)")

    private String title;
    @Column(name = "update_at", columnDefinition = "datetime(6)")
    private Instant updateAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new LinkedHashSet<>();
}
