package com.surveys.preparation.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey_answers")
public class SurveyAnswer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "question_id", nullable = false)  
    private Long questionId;
    
    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
    
    // Constructors
    public SurveyAnswer() {
        this.submittedAt = LocalDateTime.now();
    }
    
    public SurveyAnswer(Long userId, Long questionId, String answer) {
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
        this.submittedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getAnswerId() {
        return answerId;
    }
    
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}