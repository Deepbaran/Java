package com.quiz.services;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// As we will be doing load balancing for the Question service, we cannot have it's url hard coded.
// Rather than providing the url, we need to provide the service name of the Question Microservice
// Eureka Register will handle the rest automatically
// Now when the Feign Client will call the Question Service, it will not look into the url. It will check the service name/id.

//@FeignClient(url = "http://localhost:8082", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
