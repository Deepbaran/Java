package com.springdatalearning.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "courseMaterial") //Exclude courseMaterial property from the toString method implemented by the @Data annotation
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    //Making the relation/mapping between Course and CourseMaterial bi-directional
    @OneToOne(
            mappedBy = "course"
    ) //No need to define the One to one mapping or JoinColumn again as it is already mapped by the course property in CourseMaterial
    private CourseMaterial courseMaterial;

    //This particular course is taught by whom?
    @ManyToOne(
            cascade = CascadeType.ALL
    ) //Many to One uni-directional relationship
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    //May to Many relationship with Student
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    ) //A new table will get crated for Many to Many mapping, called, student_course_mapping. This will have two columns, course_id and student_id. course_id will refer to the courseId of the course class, student_id will refer to the studentId of the Student class and inverseJoinColumnJoin will be Student (Whatever we are defining it for. Simply the other entity).
    private List<Student> students;

    public void addStudents(Student student) {
        if(this.students == null) {
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }
}
