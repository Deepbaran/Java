package for_loop;

import java.util.Scanner;

public class BreakDemo {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int n = scan.nextInt();
		int d = 2;
		boolean divided = true;
		while(d < n) {
			if(n % d == 0) {
				divided = false;
				break; // break the immediate loop
			}
		}
		if(divided) {
			System.out.println("Not Prime");
		} else {
			System.out.println("Prime");
		}

	}

}
