package com.springlearning.Springboot.tutorial.repository;

import com.springlearning.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //By using Spring Data JPA, we can use all the methods that are already implemented by JpaRepository generic class
    //If we need some custom queries, we can define them in this repository
    //For writing custom queries either in JPQL or SQL, we can use the @Query annotation
    //Pass Entity and Primary key type to JpaRepository class generic

    // No need for implementation. With the naming convention, we should get our data
    // Make sure that the entity and property names are correct.
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
