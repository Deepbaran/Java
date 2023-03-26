package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // As Student is an Entity, we can access all of its properties using JPQL
    @Query("SELECT s FROM student s WHERE s.email = ?1") //JPQL and not SQL. Provide the Entity name not the Object name if a explicit name is defined for the Entity
    Optional<Student> findStudentByEmail(String email);
}
