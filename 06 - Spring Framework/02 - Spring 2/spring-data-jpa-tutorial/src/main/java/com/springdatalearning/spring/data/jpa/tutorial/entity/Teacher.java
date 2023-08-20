package com.springdatalearning.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;


    //M-1 relationship is more readable and understandable, and it is a guidance specified by JPA that you should always go for M-1 relationship whenever possible
    //So, we are defining this as ManyToOne relationship in Course Entity
//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    ) //A new column (Foreign Key) will be added to the Course table, called teacher_id. As teacher's property is used here, the column will be added into the course table
//    private List<Course> courses;
}
