package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

//Repository
//Transaction - This makes sure that all queries are either completely successful or completely fails
@Repository
@Transactional
public class PersonJpaRepository {
	
	//connect to the database
	@PersistenceContext
	EntityManager entityManager; //EntityManager is the interface of PersistenceContext
	
	public List<Person> findAll() {
		//Using JPQL (Java Persistence Query Language). With JPA, we use JPQL instead of SQL.
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class); //This Named Query is defined for Person Entity using @NamedQuery annotation
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id); // Find the Person entity by id
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
		// merge -> If an id is inside the person and there is a similar id inside the database then hibernate will try to merge these two and if there is no similar id is inside the database then hibernate will ignore the passed id and assign a id according to the sequence.
		// If there is no id here, then it will insert it.
		// So, if not updated then inserted.
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);		
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

}
