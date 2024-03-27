package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Controller - API Layer
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired // Constructor Autowiring / Dependency Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        // @RequestBody will map the request payload to the Student Object/Entity
        /*
        Header:
            Content-Type:application/json

        Body:
        {
            "name": "Deep",
            "email": "deep@email.com",
            "dob": "1997-12-23"
        }
         */
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // @PathVariable helps is accessing the url parameter
        // SO we will pass the student id in the path
        // http://localhost:8080/api/v1/students/3
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "email", required = false) String email
    ) {
        // @RequestParam means that these parameters may be passed in the request body. But they are set as not required.
        // http://localhost:8080/api/v1/students/3?name=Deep3&email=deep3@email.com
        studentService.updateStudent(studentId, name, email);
    }
}
