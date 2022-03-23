import java.util.Scanner;

public class ArrayUse2 {
	
	public static int LargestInArray(int input[]) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}
	
	public static int[] takeInput() {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int input[] = new int[size];
		
		for(int i = 0; i < size; i++) {
			input[i] = scan.nextInt();
		}
		
		return input;
	}
	
	public static void print(int input[]) {
		int size = input.length; // length of the array
		
		for(int i = 0; i < size; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = takeInput();
		print(arr);
		System.out.println(LargestInArray(arr));
	}

}
