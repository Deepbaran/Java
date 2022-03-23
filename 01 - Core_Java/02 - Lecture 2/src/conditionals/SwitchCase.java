package conditionals;

public class SwitchCase {

	public static void main(String[] args) {
		int x = 2;
		
		switch(x) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		default:
			System.out.println("!");
			break;
		}
		
		// If no case is executed then only default case is executed		
		// For swith case we can use int, char and String
	}

}