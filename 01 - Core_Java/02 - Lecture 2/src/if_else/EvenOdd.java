package if_else;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n % 2 == 0) {
			System.out.println("even");
			return; // terminate main
		} else {
			System.out.println("odd");
		}
	}

}
