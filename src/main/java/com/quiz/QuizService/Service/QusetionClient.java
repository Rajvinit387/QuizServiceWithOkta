package com.quiz.QuizService.Service;


import com.quiz.QuizService.Entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url="http://localhost:7001", value = "Question-Client")
@FeignClient(name="QUESTION-MICROSERVICE")
public interface QusetionClient {



    @GetMapping("/question/findQuestionByQuizId/{id}")
    List<Question> getQuestionsbyQuiz(@PathVariable long id);
}
