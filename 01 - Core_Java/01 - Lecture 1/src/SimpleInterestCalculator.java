import java.util.Scanner;

public class SimpleInterestCalculator {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		/*
		int  p = scan.nextInt();
		int  r = scan.nextInt();
		int  t = scan.nextInt();
		*/
		
		String str = "abcd";
		System.out.println(str);
		
		int a = scan.nextInt();
		System.out.println("int: " + a);
		
//		We cannot take character input but we can take string input
		String str2 = scan.next(); // It breaks the input stream at space
		System.out.println("next: " + str2);
		
		String str3 = scan.nextLine(); // It takes the input till next line
		System.out.println("nextLine: " + str3);
		
		/*
			nextLine takes the new line character from previous input as input too.
			all the scanner methods leave a new line at the end. Which is mistakenly taken as input by nextLine
			So, after using other scanner methods immediately before nextLine, we need to take the new line character as input in a empty nextLine method
			The use is shown below:
		*/
		double d = scan.nextDouble();
	    scan.nextLine(); // this takes the new line as input 
	    String s = scan.nextLine();
	    System.out.println("Double: " + d);
	    System.out.println("String: " + s);
		
		// To take character input, first take string input then assign the 0th character to a char variable
		char c = str.charAt(0);
		
		
		// Output formatting
		String s1=scan.next();
        int x=scan.nextInt();
        System.out.printf("%-15s%03d%n", s1, x);
		
		/*
		long l = scan.nextLong();
		double d = scan.nextDouble();
		float f = scan.nextFloat();
		*/
		
		
		/*
		int p = 1000;
		int r = 10;
		int t = 5;
		*/
		/*
		int si = (p * r * t) / 100;
		System.out.println(si);
		*/
		
		/*
		 	Scanner s = new Scanner(System.in);
			String str = s.next();
			int a = s.nextInt();
			System.out.print(str + " " + a);
		 */
		
		/*
		 "s.next()" scans and returns the next token as String. 
		 A token is part of entered line that is separated from other tokens by space, tab or newline. 
		 So when input line is - “abc def 10” then s.next() returns the first token as String 
		 i.e. “abc” and s.nextInt() tries to convert the next token i.e. “def” into an int, 
		 which gives InputMismatchException.
		 */
	}
}
