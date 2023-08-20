package com.springdatalearning.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                // making email_address column unique
                name = "emailid_unique",
                columnNames = "email_address"
        )
) // student entity will be mapped to tbl_student table. If table does not exist then it will be created.
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    ) //DB creates a default sequence table if we do not define it ourselves for auto incrementing sequentially. So, here we are creating our own custom, Sequence table using this
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    ) // We are using SEQUENCE and strategy as we are defining our own SequenceGenerator.
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false // making this column non nullable
    ) // emailId property of the entity will be represented by email_address column/field in the table. Ideally this annotation should be defined for all the fields.
    private String emailId;

    // Ideally we should have a different class for all of these three properties, Guardian
    // And we do not want a separate entity for these. We just want a separate class holding them only for the Student entity (tbl_student table)
    // For this Student class will embed the Guardian class into itself
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    private Guardian guardian;
}
