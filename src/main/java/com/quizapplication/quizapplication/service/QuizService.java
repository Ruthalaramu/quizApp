package com.quizapplication.quizapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapplication.quizapplication.dao.QuestionsRepository;
import com.quizapplication.quizapplication.dao.QuizDao;
import com.quizapplication.quizapplication.model.QuestionWrapper;
import com.quizapplication.quizapplication.model.Questions;
import com.quizapplication.quizapplication.model.Quiz;
import com.quizapplication.quizapplication.model.Response;

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

    public  ResponseEntity <List<QuestionWrapper>> getQuiz(int id) {
      try {
        Optional<Quiz> quiz = quizDao.findById(id);
       List<Questions> questionsfromDb=quiz.get().getQuestions();
       List<QuestionWrapper> questionFromUser= new ArrayList<>();
       for(Questions q:questionsfromDb){
        QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        questionFromUser.add(qw);
       }
       return  new ResponseEntity<List<QuestionWrapper>>(questionFromUser,HttpStatus.OK);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return new ResponseEntity<List<QuestionWrapper>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <Integer> submitQuiz(int id, List<Response> response) {
      Quiz quiz=quizDao.findById(id).get();
      List<Questions> questions=quiz.getQuestions();
      int count=0;
      int i=0;
      for(Response res:response){
        if(res.getResponse().equals(questions.get(i).getRightAnswer())){
           count++;
           i++;
        }
      }
      return new ResponseEntity<>(count,HttpStatus.OK) ;
    }

   

    
}
