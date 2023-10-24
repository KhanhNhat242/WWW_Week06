package com.example.WWW_Week06.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Data
public class User {
    @Id
    @Column(columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 5, columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "first_name", columnDefinition = "varchar(50)")
    private String firstName;

    @Lob
    @Column(columnDefinition = "tinytext")
    private String intro;

    @Column(name = "last_login", columnDefinition = "datetime(6)")
    private Instant lastLogin;
    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "middle_name", columnDefinition = "varchar(50)")
    private String middleName;
    @Column(columnDefinition = "varchar(15)")
    private String mobile;
    @Column(name = "password_hash", columnDefinition = "varchar(32)")
    private String passwordHash;

    @Lob
    @Column(columnDefinition = "tinytext")
    private String profile;

    @Column(name = "registered_at", columnDefinition = "datetime(6)")
    private Instant registeredAt;

    public User(String email, String firstName, String intro, Instant lastLogin, String lastName, String middleName, String mobile, String passwordHash, String profile, Instant registeredAt) {
        this.email = email;
        this.firstName = firstName;
        this.intro = intro;
        this.lastLogin = lastLogin;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobile = mobile;
        this.passwordHash = passwordHash;
        this.profile = profile;
        this.registeredAt = registeredAt;
    }
}
