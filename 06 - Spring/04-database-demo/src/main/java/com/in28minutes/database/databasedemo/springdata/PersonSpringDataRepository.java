package com.in28minutes.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
	/*
	 Rather than defining the functions, findAll, findById, update, insert, deleteById individually for each Entity, JPA provides a interface called JpaRepository<EntityToManage, PrimaryKeyDataType>.
	 It has all the above methods pre-defined.
	 The only difference is that, for JPA we use merge() inside insert and update. But for JpaRepository, we will use save() to perform both.
	 So, we have the below methods:
	 findAll()
	 findById()
	 save() [Insert and Update]
	 deleteById 
	 */
}
