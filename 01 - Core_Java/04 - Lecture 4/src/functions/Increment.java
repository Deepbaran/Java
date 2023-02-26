package functions;

public class Increment {
	
	/*
	 * In Java EVERYTHING is PASS BY VALUE
	 */

	public static void increment(int n) {
		/*
		 * n is passed as passed by value
		 * It means that only the VALUE of the variable is passed to n not the variable itself 
		 * a and n hold the same value but these two are not the same variables
		 * So, any changes made to n, will not make changes to a implicitly
		 */
		n = n + 1;
		System.out.println(n); // 11
	}
	
	public static void main(String[] args) {
		int a = 10;
		increment(a); // only the VALUE of a is passed as argument.(Pass by value)
		System.out.println(a); // 10
	}

}
