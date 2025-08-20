package com.surveys.preparation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.surveys.preparation.demo.model.SurveyUser;
import com.surveys.preparation.demo.repository.SurveyUserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class SurveyUserController {
    
    @Autowired
    private SurveyUserRepository surveyUserRepository;

    @PostMapping("/signup")
    public SurveyUser signup(@RequestBody SurveyUser user) {
        return surveyUserRepository.save(user);
    }
}