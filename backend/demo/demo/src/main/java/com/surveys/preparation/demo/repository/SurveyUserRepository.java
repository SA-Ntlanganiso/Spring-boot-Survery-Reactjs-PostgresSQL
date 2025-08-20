package com.surveys.preparation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.surveys.preparation.demo.model.SurveyUser;

@Repository
public interface SurveyUserRepository extends JpaRepository<SurveyUser, Integer> {
    boolean existsByEmail(String email);
}