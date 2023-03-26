package com.example.demo;

import javax.persistence.*;

//@Entity and @Table should come from jpa/persistance API (javax.persistence) and not the hibernate api
//In this way if we wish to change the underlying ORM from hibernate to something else, we can do so without any hassle

// Telling Spring to map this class to a table.
// It is a good practice to be explicit about the entity name. The default is the Class name
@Entity(name = "Student") // This is for Hibernate
@Table(
        name = "student",
        uniqueConstraints = {
                // Making email column unique with a unique constraint name.
                // We could have made it unique by passing the unique=true parameter in the @Column() annotation also
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                )
        }
) // This is for our table in our DB
public class Student {

    @Id //This property is a Primary Key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    ) // Adding a sequence to the id column which will start from 1 by default and will be increased by 1 (because of the allocationSize)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    ) // The generated value will follow the Sequence strategy and generator it will follow is student_sequence
    @Column(
            name = "id",
            updatable = false
    ) // As updatable is false, so no one can update it
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    public Student() {
        // Entities are required to have a no-parameter constructor
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   Integer age) {
        // No need to pass id as it is backed by a sequence. We do not need to do anything
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
