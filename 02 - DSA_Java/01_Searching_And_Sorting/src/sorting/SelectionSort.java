package sorting;

/*
Selection Sort: Similar to bubble sort, but instead of first placing large values into sorted position, it places small values into sorted position.
Pseudo Code:
1. Store the first element as the smallest value you've seen so far.
2. Compare this item to the next item in the array until you find a smaller number.
3. If a smaller number is found, designate that smaller number to be the new 'minimum' and continue until the end of the array.
4. If the 'minimum' is not the value (index) you initially began with, swap the two values.
5. Repeat this with the next element until the array is sorted.
*/

import java.util.Scanner;

public class SelectionSort {

	public static void takeInput(int arr[]) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
//		scan.close();
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void selectionSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) { // for n-1 rounds
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size];
		takeInput(arr);
		selectionSort(arr);
		print(arr);
	}

}
