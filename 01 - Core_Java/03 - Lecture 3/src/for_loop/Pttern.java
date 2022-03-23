package for_loop;

public class Pttern {

	public static void main(String[] args) {
		int n = 4;
		int i = 1;
		while(i <= n) {
			int j = 1;
			while(j <= n) {
				System.out.print(j + " ");
				j++;
				if(j > i) {
					break; // breaks the immediate while loop
				}
			}
			System.out.println();
			i++;
		}

	}

}
