package com.springdatalearning.spring.data.jpa.tutorial.repository;

import com.springdatalearning.spring.data.jpa.tutorial.entity.Course;
import com.springdatalearning.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        //Now these courses will be created without course materials.
        //Ideally courses should not be allowed to get created without course materials.
        //To take care of this, we can use a property called Optionality. Optionality defines if it is an optional relationship or mandatory relationship.
        //By default, everything is Optional, which why we were allowed to create Courses without Course Material.
        //We need to make Optionality mandatory
        //With optionality being mandatory, if we try to save a Course without Course Material or vice versa, we will get the below error:
        //not-null property references a null or transient value

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Diba1")
                .lastName("Hazra")
                //.courses(List.of(courseDBA, courseJava)) //This mapping has been commented out
                .build();

        teacherRepository.save(teacher);
//        Hibernate: select next_val as id_val from teacher_sequence for update
//        Hibernate: update teacher_sequence set next_val= ? where next_val=?
//        Hibernate: select next_val as id_val from course_sequence for update
//        Hibernate: update course_sequence set next_val= ? where next_val=?
//        Hibernate: select next_val as id_val from course_sequence for update
//        Hibernate: update course_sequence set next_val= ? where next_val=?
//        Hibernate: insert into teacher (first_name, last_name, teacher_id) values (?, ?, ?)
//        Hibernate: insert into course (credit, title, course_id) values (?, ?, ?)
//        Hibernate: insert into course (credit, title, course_id) values (?, ?, ?)
//        Hibernate: update course set teacher_id=? where course_id=?
//        Hibernate: update course set teacher_id=? where course_id=?
    }
}