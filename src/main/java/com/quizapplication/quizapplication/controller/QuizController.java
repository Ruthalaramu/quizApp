package com.quizapplication.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapplication.quizapplication.model.QuestionWrapper;
import com.quizapplication.quizapplication.model.Response;
import com.quizapplication.quizapplication.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity <String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title ){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/getQuiz/{id}")
   public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
    return quizService.getQuiz(id);
    
   }
   @PostMapping("/submitQuiz/{id}")
   public  ResponseEntity<Integer> submitQuiz(@PathVariable int id , @RequestBody List<Response>  response ){
    return quizService.submitQuiz(id,response);
    
   }

    
}
