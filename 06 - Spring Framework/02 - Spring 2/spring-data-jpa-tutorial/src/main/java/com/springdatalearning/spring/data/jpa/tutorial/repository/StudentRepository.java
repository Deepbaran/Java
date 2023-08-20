package com.springdatalearning.spring.data.jpa.tutorial.repository;

import com.springdatalearning.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //JpaRepository extends PagingAndSortingRepository and QueryByExampleExecutor
    //PagingAndSortingRepository extends CrudRepository
    //The first should be the entity for which we are creating this repository and the second should be the type of the Primary Key

    // The name of the custom methods has to be in the format that has been defined.
    List<Student> findByFirstName(String firstName); //Get records by first name

    List<Student> findByFirstNameContaining(String name); //Get records by first name where the first name contains the passed String

//    List<Student> findByLastNameNotNull(String lastName); //Get records by last name where last name is not null

    List<Student> findByGuardianName(String guardianName); //Get records depending on the Guardian class's name attribute

//    Student findByFirstNameAndLastName(String firstName, String LastName); //Get records depending on the first name and last namse

    // Define custom queries using JPQL and SQL
    @Query(value = "select s from Student s where s.emailId = ?1") //JPQL
    Student getStudentByEmailAddress(String emailId);

    @Query(value = "select s.firstName from Student s where s.emailId = ?1") //JPQL
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    ) //SQL
    Student getStudentByEmailAddressNative(String emailId);

    // Query Named Parameters
    // Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    ) //SQL
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying // This annotation will make sure that our query can modify the data that is saved in the DB. As this is a modifying query, we need a Transaction for it
    @Transactional //With this, after the transaction (create, update, delete), the changes/transactions will be committed to the DB. Ideally this annotation will be added at the Service layer where multiple modifying queries/transactions will be made and to make the entire transactions commit altogether.
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId); //We are using return type as int because this will return the number of records affected due to the update query. Same for delete and create.
}
