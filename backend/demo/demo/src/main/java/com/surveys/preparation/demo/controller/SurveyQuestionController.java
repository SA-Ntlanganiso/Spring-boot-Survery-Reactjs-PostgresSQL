package com.surveys.preparation.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.surveys.preparation.demo.model.SurveyQuestion;
import com.surveys.preparation.demo.repository.SurveyQuestionRepository;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:5173")
public class SurveyQuestionController {
    
    @Autowired
    private SurveyQuestionRepository questionRepository;
    
    @GetMapping
    public List<SurveyQuestion> getAllQuestions() {
        return questionRepository.findAllByOrderByQuestionIdAsc();
    }
    
    @GetMapping("/{id}")
    public SurveyQuestion getQuestionById(@PathVariable Integer id) {
        return questionRepository.findById(id).orElse(null);
    }
}