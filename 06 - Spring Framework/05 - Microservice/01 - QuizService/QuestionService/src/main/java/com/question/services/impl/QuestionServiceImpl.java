package com.question.services.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found !!!"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }
}
