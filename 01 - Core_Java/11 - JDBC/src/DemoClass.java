
// Java Database Connectivity

/*
 * 1. import ---> java.sql
 * 2. load and register the driver ---> com.mysql.cj.jdbc.Driver
 * 3. Create connection ---> Connection
 * 4. Create a statement ---> Statement
 * 5. execute the query
 * 6. process the results
 * 7. close
 */

import java.sql.*; // import

public class DemoClass {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbctest";
		String uname = "Deepbaran2";
		String pass = "password";
		
		// DDL, DML, DQL, TCL
		// DDL: Data Definition Language. Changing the structure of the Table
		// DML: Data Manipulation Language. Change the value of a Table
		// DQL: Data Query Language
		// TCL: Transaction Query Language
		String query1 = "SELECT NAME FROM TABLE1 WHERE ID = 3"; // DQL
		String query2 = "SELECT * FROM TABLE1"; // DQL
		String query3 = "insert into table1 (id,name) values (4,\"Dabu\")"; // DML
		String query4 = "insert into table1 (id,name) values (?,?)"; // DML
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver
		Connection con = DriverManager.getConnection(url,uname,pass); // getConnection("url","username","password") is a static method of the DriverManager class
		
		/*
		Statement st = con.createStatement(); // To work with predefined queries, use PreparedStatement. Here the value is fixed but the queries will keep changing
		ResultSet rs = st.executeQuery(query2); // executeQuery returns an object of ResultSet
		*/
		
		PreparedStatement st = con.prepareStatement(query4); // Prepared Statement pre-compiles statements.
		st.setInt(1, 5); // inserted value for the first ? in query4
		st.setString(2, "Gopal"); // inserted value for the second ? in query4
		
		int count = st.executeUpdate(); // insert. As PreparedStatement already put the query, do no need to put it here
		
		ResultSet rs = st.executeQuery(query2);
		
//		query1
		/*
		rs.next();
		String name = rs1.getString("name"); // getString(columnName/columnNumber)
		System.out.println(name);
		*/
		
//		query2
		while(rs.next()) {
			String userData = rs.getInt("id") + ": " + rs.getString("name");
			System.out.println(userData);
		}
		
		// insert a new row
		/*
		int count = st.executeUpdate(query3); // executeUpdate returns number of rows that were affected by the update
		System.out.println(count + " row(s) affected");
		*/
		st.close();
		rs.close();
	}

}
