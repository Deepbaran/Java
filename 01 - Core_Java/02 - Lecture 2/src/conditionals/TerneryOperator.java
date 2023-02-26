package conditionals;

public class TerneryOperator {

	public static void main(String[] args) {
		int x = 5;
		
		int y = x > 5 ? 10 : 5;
		// condition ? (execute if condition is true) : (execute if condition is false)
		
		System.out.println(y); // 5
		
		int z = x >= 5 ? (y > 10 ? 1 : 2) : 0;
		System.out.println(z); // 2
	}

}
