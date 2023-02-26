package searching;

/*
Pseudo Code: [THE ARRAY MUST BE SORTED]
1. This function accepts a SORTED array and a value.
2. Create a left pointer at the start of the array, and a right pointer at the end of the array.
3. While the left pointer comes before or equal to the right pointer.
*/

import java.util.Scanner;

public class BinarySearching {
	
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
	
	public static int binarySearch(int arr[], int val) { // O(logn)
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
//			int mid = (start + end) / 2;
			int mid = start + (end - start) / 2;
			if(arr[mid] == val) {
				return mid;
			} else if(arr[mid] > val) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size];
		takeInput(arr);
		int x = scan.nextInt();
		int index = binarySearch(arr, x);
		print(arr);
		System.out.println(index);
//		scan.close();
	}

}
