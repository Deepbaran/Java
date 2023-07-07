package com.in28minutes.database.databasedemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity //For JPA not Spring JDBC
//@Table(name="Person") //No need to explicitly use the table name. As the table name matches with the Class
@NamedQuery(name="find_all_persons", query="select p from Person p") // Using JPQL to set NamedQuery. Here instead of the table, Person is referring to the Entity
public class Person {
	
	@Id //defining that it is the Primary Key
	@GeneratedValue //Hibernate will automatically generate value and fill this column. Hibernate will typically create a sequence and use that sequence to populate the values in the id column
	private int id; //mapped to id column in the database
	
//	@Column(name="name") //No need to use this as all the Column names match
	private String name; //mapped to name column in the database
	
//	@Column(name="location")
	private String location; //mapped to location column in the database
	
//	@Column(name="birth_date")
	private Date birthDate; //mapped to birth_date column in the database
	
	// Must for both Spring JDBC and  Hibernate
	public Person() {}
	
	// This will allow Hibernate to assign the values to the columns except id
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	
}
