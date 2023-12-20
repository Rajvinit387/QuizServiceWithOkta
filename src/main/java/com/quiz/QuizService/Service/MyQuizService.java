package com.quiz.QuizService.Service;

import com.quiz.QuizService.Entities.Quiz;

import java.util.List;

public interface MyQuizService {
    Quiz addQuiz(Quiz quiz);

    List<Quiz> getAllQuiz();

    Quiz getQuizbyId(Long quizId);
}
