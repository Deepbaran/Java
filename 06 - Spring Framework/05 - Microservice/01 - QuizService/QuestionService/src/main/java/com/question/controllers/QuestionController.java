package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // create
    @PostMapping
    public Question create(@RequestBody Question question) {
        return this.questionService.create(question);
    }

    // get all
    @GetMapping
    public List<Question> get() {
        return this.questionService.get();
    }

    // get
    @GetMapping("/{questionId}")
    public Question get(@PathVariable("questionId") Long id) {
        return this.questionService.get(id);
    }


    // get all questions of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return this.questionService.getQuestionsOfQuiz(quizId);
    }

}
