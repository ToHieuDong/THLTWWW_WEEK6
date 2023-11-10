package com.example.week6.backend.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint(20)", nullable = false)
    private long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "middle_ame", length = 50, nullable = false)
    private String middleName;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "mobile", length = 15, nullable = false)
    private String mobile;
    @Column(name = "password_hash", length = 64, nullable = false)
    private String passwordHash;
    @Column(name = "last_login", columnDefinition = "datetime", nullable = false)
    private LocalDate lastLogin;
    @Column(name = "registered_at", columnDefinition = "datetime", nullable = false)
    private LocalDate registeredAt;
    @Column(name = "intro", columnDefinition = "tinytext", nullable = false)
    private String intro;
    @Column(name = "profile", columnDefinition = "text", nullable = false)
    private String profile;

    public User(String firstName, String lastName, String middleName, String email, String mobile, String passwordHash, LocalDate lastLogin, LocalDate registeredAt, String intro, String profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.mobile = mobile;
        this.passwordHash = passwordHash;
        this.lastLogin = lastLogin;
        this.registeredAt = registeredAt;
        this.intro = intro;
        this.profile = profile;
    }

    //==========================================
//    @OneToMany(mappedBy = "id")
//    private Set<PostComment> postComments;
//    @OneToMany(mappedBy = "id")
//    private Set<Post> posts;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
