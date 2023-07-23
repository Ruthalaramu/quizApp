package com.quizapplication.quizapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapplication.quizapplication.dao.QuestionsRepository;
import com.quizapplication.quizapplication.model.Questions;

@Service
public class QuestionsService {
   @Autowired
        QuestionsRepository questionsRepository;
    public ResponseEntity< List<Questions> >getAllQuestions() {
       try{
           return new ResponseEntity<>( questionsRepository.findAll(),HttpStatus.OK);
       }catch(Exception e) {
        e.printStackTrace();
       }
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
       
    }
    
    public ResponseEntity < List<Questions>> getQuestionsBycategory(String category) {
        try{
             return new ResponseEntity<>(questionsRepository.findByCategory(category),HttpStatus.OK) ;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
       
    }

    public ResponseEntity <String>  addQuestion(Questions questions) {
         
          try {
             questionsRepository.save(questions);
             return new ResponseEntity<String>("succes",HttpStatus.CREATED) ;
          } catch (Exception e) {
           e.printStackTrace();
          }
        return new ResponseEntity<String>("error",HttpStatus.BAD_REQUEST) ;
         
       

    }

    public ResponseEntity< String>  updateQUestions(Questions questions) {
        
         try {
             questionsRepository.save(questions);
             return  new ResponseEntity<String>("successfully updated",HttpStatus.CREATED);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return  new ResponseEntity<String>("error in update",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity< String >deleteQuestions(int id) {
        
        try {
             questionsRepository.deleteById(id);
             return new ResponseEntity<String>("successfully delated",HttpStatus.CREATED) ;
            
        } catch (Exception e) {
           e.printStackTrace();
        }
         return  new ResponseEntity<String>("error in delete",HttpStatus.BAD_REQUEST);
         
    }
}
