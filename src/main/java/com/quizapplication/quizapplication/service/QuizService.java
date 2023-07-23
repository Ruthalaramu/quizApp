package com.quizapplication.quizapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapplication.quizapplication.dao.QuestionsRepository;
import com.quizapplication.quizapplication.dao.QuizDao;
import com.quizapplication.quizapplication.model.Questions;
import com.quizapplication.quizapplication.model.Quiz;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionsRepository questionsRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questions> questions=questionsRepository.findRandomByCategory(category,numQ);
      Quiz quiz= new Quiz();
      quiz.setTitle(title);
      quiz.setQuestions(questions);
      quizDao.save(quiz);
    return  new ResponseEntity<String>("success",HttpStatus.OK);
        
        
    }

    
}
