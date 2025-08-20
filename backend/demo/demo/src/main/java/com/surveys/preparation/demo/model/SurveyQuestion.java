package com.surveys.preparation.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "survey_questions")
public class SurveyQuestion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;
    
    @Column(name = "question_text", nullable = false)
    private String questionText;
    
    // Constructors
    public SurveyQuestion() {}
    
    public SurveyQuestion(String questionText) {
        this.questionText = questionText;
    }
    
    // Getters and Setters
    public Integer getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    
    public String getQuestionText() {
        return questionText;
    }
    
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}