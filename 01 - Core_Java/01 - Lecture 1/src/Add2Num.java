import java.util.Scanner;

public class Add2Num {

	public static void main(String[] args) {
 /*
		int a = 10;
		int b = 15; // 4 bytes
		
		int c = a + b;
		System.out.println(c);
		
		short s = 123; // 2 bytes
		long l = 1234; // 8 bytes
		
		double d = 1.23; // 8 bytes
		
		char ch = 'a'; // 2 bytes
		
		boolean bool = true; // true / false | true != 1 and false != 0
				
//		float f; // 4 bytes
//		System.out.println(f); // we cannot print variables that do not have any value assigned to them
		// Compiler assigns a default value to an uninitialized variable in java programming
//		In java, its compulsory to initialise any local variable before using it 
//		because compiler don't assign any default/garbage value to variables.
 * It is absolutely mandatory to initialize variables at the time of declaration in java
 * 
 * 
 */
		
		Scanner scan = new Scanner(System.in); // System.in provides the input stream to Scanner
		int i = scan.nextInt();
		int j = scan.nextInt();
		int k = i + j;
		System.out.println(k);
		scan.close(); // we need to close scan so that data does not leak
	}

}
