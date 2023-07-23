package com.quizapplication.quizapplication.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizapplication.quizapplication.model.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);


   @Query(value = "select * from questions q where q.category=:category ORDER BY LIMIT :numQ",nativeQuery=true)
    List<Questions> findRandomByCategory(String category, int numQ );
}
