package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

/*
The goal of Spring Data Repository abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores.

The StudentRepository needs to extend any of the three below repositories:
JPARepository (jpa methods, flush and batch) -extends-> PagingAndSortingRepository (pagination and sorting) -extends-> CrudRepository (crud function)
 */