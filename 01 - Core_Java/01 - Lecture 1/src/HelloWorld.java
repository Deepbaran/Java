
public class HelloWorld {
	public static void main(String args[]) {
		// If we use println java will put a newline at the end.
		System.out.println("Hello World!!!");
		System.out.print("Hello World!!!");
		System.out.println("Hello World!!!");
		// println -> new line
		// print -> same line
	}
}

/*

Java Code -Compiler-> ByteCode -> (JVM+StandardLibrary+Others)/JRE -Run-> <Execution>
Java Provides specific JVMs for every OS.

JAR - Java Archive (Runs on JVM)
WAR - Web Archive (Needs Web Servers like TomCat)
EAR - Enterprise Archive (Needs Java EE/Jakarta EE Servers like JBoss, WebFlux)

POJO - Plain Old Java
EJB - Enterprise Java Beans

1. JVM (Java Virtual Machine) runs Java bytecode. It converts bytecode to OS specific instructions.

2. JRE (Java Runtime Environment) = JVM + Libraries + Other Components. Needed by the application user.

3. JDK (Java Development Kit)= JRE + Compilers + Debuggers. Needed by application developers.

**************************************************************

int a = 100; means that the value 100 is stored in a memory location referenced by 'a'.

***************************************************************

Primitive Data Types:

Integer:
1. byte -> 8 bits -> -2^7 to (2^7)-1 OR -128 to 127
2. short -> 16 bits -> -2^15 to (2^15)-1 OR -32,768 to 32,767
3. int -> 32 bits -> -2^31 to (2^31)-1 OR -2,147,483,648 to 2,147,483,647
4. long -> 64 bits -> -2^63 to (2^63)-1

Floating Point:
1. float -> 32 bits. float f = 4.0f; floating point constant or literal is y default a double. That's why we use f at the end of floating value literal.
2. double -> 64 bits

Character:
1. char -> 16 bits -> '\u0000' to '\uffff'

Boolean:
boolean -> true or false -> true != 1 and false != 0

*****************************************************************

Number + Number = Number => 1 + 2 = 3

String Concatenation:

String + Number = String => "1" + 2 = "12"

String + String = String => "A" + "B" = "AB"

******************************************************************

A function has arguments and we pass parameters to it.

Method Overloading:
In Java, two or more methods can have same name if they differ in parameters (different number of parameters, different types of parameters, or both). 
These methods are called overloaded methods and this feature is called method overloading.

******************************************************************

Class:
Class is a template. This template can be used to create multiple instances of this class.

class Country {
	// code
}

Objects:
The instances of the class are called objects.

Country india = new Country(); // india is the object of the County class
// india object is now stored in a memory
// objects are stored in the memory and they are referenced by object name.
// So, india is only a reference(memory address) that point to where the object is really stored.

// india is a variable of type Country
// We can store india to another variable of type Country

 Country India = india; // this is valid
 // in the above code, the reference(memory address) that india is pointing to is stored in India
 // So, both india and India are pointing towards to the same memory address where the object is stored.

 */
