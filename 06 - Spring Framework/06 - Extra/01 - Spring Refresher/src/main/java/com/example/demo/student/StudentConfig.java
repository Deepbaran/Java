package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    // CommandLineRunner will run just after the server starts
    // So it is a good place to put any configurations that we wish to add after the server runs
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student deep1 = new Student(
                    "Deep1",
                    "deep1@email.com",
                    LocalDate.of(1997, Month.JANUARY, 5)
            );

            Student deep2 = new Student(
                    "Deep2",
                    "deep2@email.com",
                    LocalDate.of(1997, Month.JANUARY, 5)
            );

            studentRepository.saveAll(
                    List.of(deep1, deep2)
            );
        };
    }

}
