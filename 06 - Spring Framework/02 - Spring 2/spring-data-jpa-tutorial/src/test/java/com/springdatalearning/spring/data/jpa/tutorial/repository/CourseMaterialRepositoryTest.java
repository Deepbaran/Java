package com.springdatalearning.spring.data.jpa.tutorial.repository;

import com.springdatalearning.spring.data.jpa.tutorial.entity.Course;
import com.springdatalearning.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        //This will throw an error - object references an unsaved transient instance
        //As we are trying to save CourseMaterial without saving the Course
        //So, for this CourseMaterial, we will need to use a Course that is already saved in the DB
        //As Course is not embedded into CourseMaterial, we need to save Course first
        //To make this happen, Cascading comes into picture
        //Cascading means passing permission to Child elements
        //So, currently we have a CourseMaterial that we want to persist but the Course needed for it is not persisted.
        //So, we will cascade the information for persisting the unavailable (not persisted) Course object too.
        //There are different Cascading available. And depending on the one we define, this operation will happen
        //We can set this in the @OneToOne annotation

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
//        Hibernate: select next_val as id_val from course_material_sequence for update
//        Hibernate: update course_material_sequence set next_val= ? where next_val=?
//        Hibernate: select next_val as id_val from course_sequence for update
//        Hibernate: update course_sequence set next_val= ? where next_val=?
//        Hibernate: insert into course (credit, title, course_id) values (?, ?, ?)
//        Hibernate: insert into course_material (course_id, url, course_material_id) values (?, ?, ?)
    }

    @Test
    public void printAllCourseMaterials() {
        //This will throw the error - could not initialize proxy [com.springdatalearning.spring.data.jpa.tutorial.entity.Course#1]
        //This is happening because there is a toString method defined with @Data in the entity that is calling the Course
        //But as we are doing a Lazy fetch, so Course is not fetched when fetching CourseMaterial
        //For that we added @ToString(exclude = "course") to exclude course property from the toString method

        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
//        Hibernate: select coursemate0_.course_material_id as course_m1_1_, coursemate0_.course_id as course_i3_1_, coursemate0_.url as url2_1_ from course_material coursemate0_
//        courseMaterials = [CourseMaterial(courseMaterialId=2, url=www.google.com)]
    }
}