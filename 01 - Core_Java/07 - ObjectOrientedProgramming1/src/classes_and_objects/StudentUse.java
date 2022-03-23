package classes_and_objects;

import java.util.Scanner;

//import classes_and_objects.Student; // no need to import in the same package

public class StudentUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner s = new Scanner(System.in);
		Student s1 = new Student("Deepbaran Kar", 123); // s1 is storing the memory address of Student type object
		// The Student object is referred by s1
		System.out.println(s1);
		s1.print();
		
//		s1.name = "Deepbaran Kar";
//		s1.setRollNumber(123);
		
		/*
		 * new Student() creates a Student object
		 * s1 is storing the address of the Student object that was created
		 * s1 is not the Student object, it just stores the memory address where the new Student is
		 * So, s1 is not the Student rather it's the memory where the object is stored
		 * So, there will be two memory spaces created. one for the object and the other to store it's memory(s1)
		 * 
		 * We refer to the properties and functionalities of the newly created Student objects through the variable which is storing it's address
		 * 
		 * "new" operator is used to allocate memory for an object
		 */
		
		//constructor 3
		Student s2 = new Student("Dabu", 121);
		System.out.println(s2);
		s2.print();
		
//		s2.name = "Dabu";
//		s2.setRollNumber(121);
		
//		System.out.println(s1.name);
//		System.out.println(s1.getRollNumber());
//		System.out.println(s2.name);
//		System.out.println(s2.getRollNumber());
		
		// constructor 2
//		Student s3 = new Student("Dibakar");
//		s3.print();
		
		// constructor 1
//		Student s4 = new Student();
//		s4.print();
		
//		System.out.println(s1.getNumStudents()); // Should not use
//		System.out.println(s2.getNumStudents()); // Should not use
		System.out.println(Student.getNumStudents()); // Correct way to access static members
				
		s.close();
	}

}
