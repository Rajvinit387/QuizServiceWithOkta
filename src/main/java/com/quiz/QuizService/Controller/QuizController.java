package com.quiz.QuizService.Controller;


import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Service.MyQuizService;
import com.quiz.QuizService.Service.QusetionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController
{


    @Autowired
    private MyQuizService myQuizService;

    @Autowired
    private QusetionClient qusetionClient;

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody  Quiz quiz)
    {
        this.myQuizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz);
    }


    @GetMapping
    public List<Quiz> getAllQuiz()
    {

        return this.myQuizService.getAllQuiz();
    }


    @RequestMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id)
    {
        return  this.myQuizService.getQuizbyId(id);
    }


}
