package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return this.quizService.add(quiz);
    }

    // get all
    @GetMapping
    public List<Quiz> get() {
       return this.quizService.get();
    }

    // get
    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id) {
        return this.quizService.get(id);
    }
}
