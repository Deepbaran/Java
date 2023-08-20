package com.springdatalearning.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") //Exclude course property from the toString method implemented by the @Data annotation
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    // CourseMaterial has to have a Course in it. It cannot exist without a Course. And vice-versa
    // So we will need to map a course to it.
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false //It is a mandatory relationship. To save a Course, a Course Material is mandatory and vice-versa
    ) //Because of OneToOne relationship, for every course there will be one CourseMaterial
    @JoinColumn(
            name = "course_id", //column name of this foreign key in the course_material table
            referencedColumnName = "courseId" //property name of the Entity, Course, to reference to
    ) //Define for which column we can join these two tables (Foreign Key). As Course's property is used here, the column will be added into the course_material table
    private Course course; //Now Course is mapped with CourseMaterial with one-to-one mapping where course_id is the foreign key in CourseMaterial
    //For creating a CourseMaterial now we need to pass a Course object too.
}
