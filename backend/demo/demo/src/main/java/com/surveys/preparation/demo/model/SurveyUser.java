package com.surveys.preparation.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey_users")
public class SurveyUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    private String name;
    private String email;
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
    
    // Constructors
    public SurveyUser() {
        this.submittedAt = LocalDateTime.now();
    }
    
    public SurveyUser(String name, String email) {
        this.name = name;
        this.email = email;
        this.submittedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}