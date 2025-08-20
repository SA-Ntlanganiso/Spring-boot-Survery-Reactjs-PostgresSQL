package com.surveys.preparation.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.surveys.preparation.demo.model.SurveyAnswer;
import com.surveys.preparation.demo.repository.SurveyAnswerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "http://localhost:5173")
public class SurveyAnswerController {
    
    @Autowired
    private SurveyAnswerRepository answerRepository;
    
    @PostMapping
    public ResponseEntity<SurveyAnswer> submitAnswer(@RequestBody SurveyAnswer answer) {
        try {
            SurveyAnswer savedAnswer = answerRepository.save(answer);
            return ResponseEntity.ok(savedAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/batch")
    public ResponseEntity<List<SurveyAnswer>> submitAnswers(@RequestBody List<SurveyAnswer> answers) {
        try {
            List<SurveyAnswer> savedAnswers = answerRepository.saveAll(answers);
            return ResponseEntity.ok(savedAnswers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SurveyAnswer>> getUserAnswers(@PathVariable Long userId) {
        try {
            List<SurveyAnswer> answers = answerRepository.findByUserId(userId);
            return ResponseEntity.ok(answers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}