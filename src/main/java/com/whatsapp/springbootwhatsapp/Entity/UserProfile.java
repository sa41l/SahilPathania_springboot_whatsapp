package com.whatsapp.springbootwhatsapp.Entity;

import javax.persistence.*;

@Entity
@Table(
        name = "user_profile"
)
public class UserProfile {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false
    )
    private String username;
    @Column(
            nullable = false
    )
    private String email;
    @Column
    private String avatarUrl;
    @Column(
            columnDefinition = "TEXT"
    )
    private String bio;

    public UserProfile() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

