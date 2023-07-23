package com.quizapplication.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapplication.quizapplication.model.Questions;
import com.quizapplication.quizapplication.service.QuestionsService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionsService questionsService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>>  getAllQuestions(){
        return questionsService.getAllQuestions();
        
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsBycategory(@PathVariable String category){
        return questionsService.getQuestionsBycategory(category);
    }
    @PostMapping("/addQuestions")
    public ResponseEntity<String>  addQuestions( @RequestBody Questions questions){
        return questionsService.addQuestion(questions);
        
    }
    @PutMapping("/updateQuestions")
    public ResponseEntity<String>  updateQuestions(@RequestBody Questions questions){
        return questionsService.updateQUestions(questions);
        
    }
 
    @DeleteMapping("/deleteQuestions/{id}")
    public ResponseEntity<String>  deleteQuestions(@PathVariable int id){
        return  questionsService.deleteQuestions(id);

    }
    
}
