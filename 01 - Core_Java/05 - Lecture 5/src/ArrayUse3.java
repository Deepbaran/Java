import java.util.Scanner;

public class ArrayUse3 {

	public static int[] takeInput() {
		Scanner scan = new Scanner(System.in); // scan refers to the memory address where Scanner is stored
		
		int size = scan.nextInt();
		int input[] = new int[size]; // input is the reference to the memory where the array is located, i.e, input stores the address where array is located
		
		for(int i = 0; i < size; i++) {
			input[i] = scan.nextInt();
		}
		
		return input;
	}
	
	public static void increment(int i) { // this i and i at main are different. The value of i at main is passed or copied to this i
		i++;
		System.out.println("increment function: " + i);
	}
	
	public static void incrementArray(int input[]) {
		/*
		 * Everything is passed by value in Java
		 * arr holds the reference value to the array that is located in the memory and not the array itself. Just it's memory address, 
		 * i.e, the memory of the 0th element of the array
		 * When arr is passed by value to input, then it is not passing the array itself rather the value of the memory address where the array is stored
		 * So, any cahnges made to the array by either of them will be reflected to both of them
		 * arr and input refer to the same array
		 */
		
		// input = new int[5]; // here the value in input has changed, i.e, input is referring to a new array, 
		// i.e, it is holding the address of the new array
		// so, any changes made to input if the above line was uncommented would be made to the new array 
		// rather than the array whose memory address was passed
		
		for(int i = 0; i < input.length; i++) {
			input[i]++;
		}
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
		
		// int i = 10;
		// increment(i);
		// System.out.println("main function: " + i);
		
		/*
		 * Primitive datatypes are: int, long, double, float. char, short, byte.
		 * Primitive datatypes are do not refer to the memory address where the variable is stored
		 * Rather that variable is named and not referred to.
		 * So, here i does not refer to the variable but rather i is became the name of the variable when initialized
		 */
		
		
		// int arr[] = takeInput(); // arr holds the same value as input, i.e, it stores the address where array is located, i.e, refers to the memory
		// System.out.println(arr); // Memory address where array is stored: [I@27d416d9
		// [I@27d416d9 =>
		// [ : the memory is of an array
		// I : The array if of integer type
		// @ : Everything after this is the address of the array in hexadecimal
		
		/*
		 * Non-primitive datatypes: Array, String, Scanner etc.
		 * Every non-primitive datatype is stored in similar fashion
		 */
		
		int arr[] = {1, 2, 3, 4, 5};
		print(arr);
		incrementArray(arr);
		print(arr);
	}

}
