package functions;

import java.util.Scanner;

public class NcR {
	
	/*
	 * A function is a blackbox that takes input gives us the desired output
	 * A functon is defined by three things. These are:
	 * 1. what kind of input it requires
	 * 2. what kind of output it provides
	 * 3. what is the name of the function
	 * 
	 * before a function we will write "public static" for now(refer to OOPS)
	 * Functions help us to make reusable code
	 * Don't do too much computation in main
	 * When function returns or ends, the variables at function gets destroyed and the memory is freed automatically by the garbage collector
	 */
	
	public static int fact(int n) {
		int ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= i;
		}
		return ans;
	}

	public static boolean isPrime(int n) {
		int d = 2;
		while(d < n) {
			if(n % d == 0) {
				return false;
			}
			d++;
		}
		return true;
	}
	
	public static void printTillN(int n) {
		if(n <= 0) {
			return; // the function will end and nothing will return
		}
		for(int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}
	
	public static int ncr(int n, int r) { // n and r are arguments received. They hold the same values as n and r in main but they are not the same
		// Every variable in here including the arguments n and r are the local variables of function ncr
		// They can not be accessed outside of the function unless ecplicitly returned
		int num = fact(n);
		int den1 = fact(r);
		int den2 = fact(n - r);
		int ans = num / (den1 * den2);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		
		/*
		 // Do not copy code. It's bad practice
	 	 // use DRY(Don't Repeat Yourself) rule
		 
		int num = 1;
		for(int i = 1; i <= n; i++) {
			num *= i;
		}
		
		int den1 = 1;
		for(int i = 1; i <= r; i++) {
			den1 *= i;
		}
		
		int den2 = 1;
		for(int i = 1; i <= n - r; i++) {
			den2 *= i;
		}
		
		int ans = num / (den1 * den2);
		*/
		
		int ans = ncr(n, r); // ncr.n = main.n and ncr.r = main.r
		// n and r are argments sent
		System.out.println(ans);
		
		boolean ansPrime = isPrime(13);
		System.out.println(ansPrime);
		
		printTillN(10);
	
	}

}
