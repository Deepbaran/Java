package com.springdatalearning.spring.data.jpa.tutorial.repository;

import com.springdatalearning.spring.data.jpa.tutorial.entity.Course;
import com.springdatalearning.spring.data.jpa.tutorial.entity.Student;
import com.springdatalearning.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        //No ideally when you are querying the courses, you will want to query the Course materials as well
        //But when we are querying course, we are not getting the course material.
        //This is because we have defined uni-directional relation/mapping between them.
        //We do not have any course material referenced in our course.
        //We will need to make the mapping Bi-directional.
        //For this we will need to add reference of Course Material entity in to the Course Entity.

        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);

        //Before bi-directional mapping
        // courses = [Course(courseId=1, title=DSA, credit=6)]

        //After bi-directional mappingHibernate: select coursemate0_.course_material_id as course_m1_1_0_, coursemate0_.course_id as course_i3_1_0_, coursemate0_.url as url2_1_0_ from course_material coursemate0_ where coursemate0_.course_id=?
//        courses = [Course(courseId=1, title=DSA, credit=6, courseMaterial=CourseMaterial(courseMaterialId=2, url=www.google.com))]
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Diba2")
                .lastName("Hazra")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
//        Hibernate: select next_val as id_val from course_sequence for update
//        Hibernate: update course_sequence set next_val= ? where next_val=?
//        Hibernate: select next_val as id_val from teacher_sequence for update
//        Hibernate: update teacher_sequence set next_val= ? where next_val=?
//        Hibernate: insert into teacher (first_name, last_name, teacher_id) values (?, ?, ?)
//        Hibernate: insert into course (credit, teacher_id, title, course_id) values (?, ?, ?, ?)
    }

    //Pagination and Sorting

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages); //This is returning 2 pages as according to firstPageWithThreeRecords config, each page should have 3 records and there are 5 records at this moment in the Course table
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
//        totalPages = 2
//        totalElements = 4
//        courses = [Course(courseId=1, title=DSA, credit=6, courseMaterial=CourseMaterial(courseMaterialId=2, url=www.google.com), teacher=null), Course(courseId=2, title=DBA, credit=5, courseMaterial=null, teacher=Teacher(teacherId=1, firstName=Diba1, lastName=Hazra)), Course(courseId=3, title=Java, credit=6, courseMaterial=null, teacher=Teacher(teacherId=1, firstName=Diba1, lastName=Hazra))]
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit")
                            .descending()
                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                    0,
                    2,
                    Sort.by("title")
                    .descending()
                    .and(
                        Sort.by("credit")
                            .descending()
                    )
                );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
//        courses = [Course(courseId=2, title=DBA, credit=5, courseMaterial=null, teacher=Teacher(teacherId=1, firstName=Diba1, lastName=Hazra)), Course(courseId=1, title=DSA, credit=6, courseMaterial=CourseMaterial(courseMaterialId=2, url=www.google.com), teacher=null)]
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
//        courses = [Course(courseId=1, title=DSA, credit=6, courseMaterial=CourseMaterial(courseMaterialId=2, url=www.google.com), teacher=null), Course(courseId=2, title=DBA, credit=5, courseMaterial=null, teacher=Teacher(teacherId=1, firstName=Diba1, lastName=Hazra))]
    }

    // Many to Many Mapping

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Diba4")
                .lastName("Hazra")
                .build();

        Student student = Student.builder()
                .firstName("Deep5")
                .lastName("Kar")
                .emailId("deep5@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}