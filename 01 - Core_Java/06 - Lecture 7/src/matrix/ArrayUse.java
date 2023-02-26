package matrix;

import java.util.Scanner;

public class ArrayUse {
	
	public static int[][] takeInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rows = scan.nextInt();
		System.out.println("Number of columns: ");
		int cols = scan.nextInt();
		int input[][] = new int [rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.println("Enter element at " + i + " row and " + j + " column: ");
				input[i][j] = scan.nextInt();
			}
		}
		return input;
	}
	
	public static void print(int[][] arr) {
		int rows = arr.length; // length of the master array, i.e, number of rows
		int cols = arr[0].length; // length of the 0th 1D array, i.e, number of columns
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int largestColSum(int arr[][]) {
		int max = Integer.MIN_VALUE;
		int largest = 0;
		int sum = 0;
		for(int j = 0; j < arr[0].length; j++) {
			for(int i = 0; i < arr.length; i++) {
				sum += arr[i][j];
			}
			if(sum > max) {
				max = sum;
				largest = j;
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int array2D[][] = new int[rows][cols];
		
//		int arr2D[][] = new int[3][4]; // 2D array with 3 rows and 4 columns
//		System.out.println(arr2D[1][2]); // 1st row 2nd column
//		arr2D[2][0] = 15; // assigning value to 2nd row and 0th column
//		System.out.println(arr2D[2][0]);
//		
		int arr2[][] = {{1, 2, 3}, {4, 5, 6}}; // 2 rows and 3 columns
//		System.out.println(arr2); // address of the master array is present
//		System.out.println(arr2[0]); // oth element of the master array which is referencing the memory address of the 0th row 1D array
//		System.out.println(arr2.length); // length of the master array
//		System.out.println(arr2[0].length); // length of the 0th row 1D array
		print(arr2);

		int input[][] = takeInput();
		print(input);
		System.out.println(largestColSum(input));
		
		/*
		 * 2D array is a collection of 1D arrays
		 * and the 2D array name refer to the memory address of a master array(for understanding sake)
		 * which holds the memory addresses of all the 1D arrays
		 * Each 1D memory address is contiguous but all 1D arrays are not necessarily 1D arrays
		 * The elements of the master array each refer to the memory address of each 1D array
		 * 
		 * input[i][j] means,
		 * we first go to the 1D array whose memory is referred by the ith element of master array
		 * Then we go and access the jth element of that 1D array
		 */
		
	}

}
