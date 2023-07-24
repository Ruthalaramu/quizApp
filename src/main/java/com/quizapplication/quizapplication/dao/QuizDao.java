package com.quizapplication.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapplication.quizapplication.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    

    
    
}
