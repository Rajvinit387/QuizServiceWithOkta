package com.quiz.QuizService.Service.impl;

import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Service.MyQuizService;
import com.quiz.QuizService.Service.QusetionClient;
import com.quiz.QuizService.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MyQuizServiceimpl  implements MyQuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QusetionClient qusetionClient;

    @Override
    public Quiz addQuiz(Quiz quiz) {
       Quiz quiz1= this.quizRepository.save(quiz);
       quiz1.setQuestions(qusetionClient.getQuestionsbyQuiz(quiz.getId()));
       System.out.println(quiz1.getQuestions().get(0).getQuestion());
       return  quiz1;

    }

    @Override
    public List<Quiz> getAllQuiz() {

        List<Quiz> quizzes = this.quizRepository.findAll();
        List<Quiz> finalQuizList= quizzes.stream().map(quiz -> {quiz.setQuestions(qusetionClient.getQuestionsbyQuiz(quiz.getId()
        ));
        return quiz;
    }).collect(Collectors.toList())
;

return  finalQuizList;
    }

    @Override
    public Quiz getQuizbyId(Long quizId) {

        Quiz quiz= this.quizRepository.findById(quizId).get();
        quiz.setQuestions(qusetionClient.getQuestionsbyQuiz(quiz.getId()));
        return  quiz;
    }
}
