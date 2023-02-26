package for_loop;

import java.util.Scanner;

public class SumTillN {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		
//		 for(initialization1, initialization2,.....; condition1 &&/|| condition2 &&/|| condition3....; update1, update2,...) {statements}
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		int sum1 = 0;
		for(int i = 1, j = n; i <= n && sum1 < 100; i++, j--) {
			sum1 += i;
			System.out.print(j + " ");
		}
		System.out.println(sum1);
	}

}
