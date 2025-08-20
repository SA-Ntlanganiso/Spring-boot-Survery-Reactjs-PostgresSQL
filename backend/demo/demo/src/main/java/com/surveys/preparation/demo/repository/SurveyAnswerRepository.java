package com.surveys.preparation.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.surveys.preparation.demo.model.SurveyAnswer;
import java.util.List;

@Repository
public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer, Long> {
    List<SurveyAnswer> findByUserId(Long userId);
    List<SurveyAnswer> findByQuestionId(Long questionId);
}