package for_loop;

public class ContinueDemo {

	public static void main(String[] args) {
		int i = 1;
		while(i <= 10) {
			if(i == 5) {
				i++;
				continue; // continue skips the current iteration without executing the rest of the code
			}
			System.out.println(i);
			i++;
		}
		
		// In for loop, initialization is executed only once(at the beginning), conditions are checked before every iteration and
		// values are updated after each iteration
		
		for(int j = 1; j <= 10; j++) {
			if(j == 5) {
				continue;
			}
			System.out.println(j);
		}

	}

}
