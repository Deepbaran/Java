import java.util.Scanner;

public class FahToCel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		int f = scan.nextInt();
//		int cel = (5 / 9) * (f - 32); // 5 / 9 = 0.55 => 0 <- only the integer part is taken
//		int cel = (5 * (f - 32)) / 9; // one method
		int cel = (int)(5.0 / 9) * (f - 32); // second method. The expression will become a double and then we will typecast it into int
		System.out.println(cel);
		double a = 6 / 4; // int / int = int => 6 / 4 = 1. i.e, only the decimal part 1 will be stored in variable a as decimal 1.0
        int b  = 6 / 4; // 1
        double c = a + b; // 1.0 + 1 = 2.0
        System.out.println(c); // 2.0
		*/
		
		/*
		 * int / int = int
		 * int / double = double
		 * double / int = double
		 * double / double = double
		 * 
		 * char + int = int
		 */		
	}

}
