package while_loop;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = 2;
		while(d <= n - 1) { // 2 to (n - 1)
			if(n % d == 0) { // check if n is divisible by 2 to (n - 1)
				System.out.println("Not Prime");
				return;
			}
			d++;
		}
		System.out.println("Prime");
	}

}
