package com.quiz.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// We do not want to save this to the database, so removed @Entity, @Id and @GeneratedValue
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long questionId;
    private String question;

    private Long quizId;
}