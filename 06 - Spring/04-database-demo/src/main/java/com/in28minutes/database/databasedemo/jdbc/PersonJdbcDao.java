package com.in28minutes.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate; // Used to connect to the database
	// Spring Autoconfiguration is automatically configuring the JdbcTemplate to H2
	// Database as the H2 database is in the CLASSPATH and
	// spring.h2.console.enabled=true
	// Database is autoconfigured when we have either a DataSource or a
	// EmbeddedDatabase, which is H2 in this case.

	// Custom RowMapper
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}

	}

	// select * from person
	public List<Person> findAll() {
//		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class)); // This returns a ResultSet which is mapped to the Person Class.
		// Each row that is returned is mapped to the Class Person and a new Person
		// object is created.
		// The class on which we are using the BeanPropertyRowMapper, must have a no
		// argument constructor.

		// Mapping using a custom Row Mapper
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	@SuppressWarnings("deprecation")
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
		// queryForObject -> Querying for a specific thing
	}

	public int deleteById(int id) {
		// Returns how many rows were affected/deleted
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id }); // returns how many rows were
																							// updated/deleted
	}

	public int insert(Person person) {
		// Returns how many rows were affected/inserted
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		// Returns how many rows were affected/updated
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date= ? where id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}

}
