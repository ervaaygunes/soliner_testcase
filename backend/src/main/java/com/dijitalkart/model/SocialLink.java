package com.dijitalkart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "social_links")
public class SocialLink {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 50)
    private String platform; // github, linkedin, twitter, instagram, etc.
    
    @NotBlank
    @Size(max = 255)
    private String url;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    
    public SocialLink() {}
    
    public SocialLink(String platform, String url, User user) {
        this.platform = platform;
        this.url = url;
        this.user = user;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
} 