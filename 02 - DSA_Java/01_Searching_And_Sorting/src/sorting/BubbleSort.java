package sorting;

/*
Bubble Sort: A Sorting Algorithm where the largest values bubble up to the top!
Pseudo Code: [With each outer loop the biggest unsorted value gets sorted]
1. Start looping from with a variable called i at the end of the array towards the beginning of the array. (As we need to shrink the size of the inner loop as the array gets sorted)
2. Start an inner loop with a variable called j from the beginning until i - 1. (As with each outer loop the biggest unsorted value gets sorted, we just need to sort the rest of the elements)
3. If arr[j] is greater than arr[j + 1], swap those two values.
*/

import java.util.Scanner;

public class BubbleSort {

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
	
	public static void bubbleSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
	        for(int j = 1; j < arr.length - i; j++) {
	            if(arr[j] < arr[j - 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j - 1];
	                arr[j - 1] = temp;
	            } 
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size];
		takeInput(arr);
		bubbleSort(arr);
		print(arr);
	}

}
