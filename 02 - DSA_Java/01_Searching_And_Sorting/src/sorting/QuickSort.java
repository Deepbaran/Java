package sorting;

/*
Quick Sort: 
1. Like merge sort, exploits the fact that arrays of 0 or 1 elements are always sorted.
2. Works by selecting one element (called the "pivot") and finding the index where the pivot should end up in the sorted array.

Pivot Helper:
1. In order to implement merge sort, it's useful to first implement a function responsible for arranging elements in an array on either side of a pivot.
2. Given an array, this helper function should designate an elementas the pivot.
3. It should then rearrange elements in the array so that all values less than the pivot are moved to the left of the pivot, and all the values greater than teh pivot are moved to the right of the pivot.
4. The order of the elements on the either side of the pivot doesn't matter!
5. The helper should do this in place, that is, it should not create a new array.
6. When complete, the helper should return index of the pivot.

Picking a pivot:
1. The runtime of quick sort depends in part on how one selects the pivot.
2. Ideally, the pivot should be chosen so that it's roughly the median value in the data set you're sorting.
3. For simplicity, we'll always choose the pivot to be the first element (Though there are some consequences to this approach).

Pivot Pseudocode:
1. It will help to accept three arguments: an array, a start index, and an index (these can default to 0 and the array length minus 1, respectively)
2. Grab the pivot from the start of the array
3. Store the current pivot index in a variable (this will keep track of where the pivot should end up)
4. Loop through the array from the start until the end
  a. If the pivot is greater than the current element, increment the pivot index variable and then swap the current element with the element at the pivot index.
5. Swap the starting element (i.e. the pivot) with the pivot index.
6. Return the pivot index.

There are two indices i and j and at the very beginning of the partition algorithm i points to the first element in the array and j points to the last one. 
Then algorithm moves i forward, until an element with value greater or equal to the pivot is found. 
Index j is moved backward, until an element with value lesser or equal to the pivot is found. 
If i ≤ j then they are swapped and i steps to the next position (i + 1), j steps to the previous one (j - 1). Algorithm stops, when i becomes greater than j.
*/

import java.util.Scanner;

public class QuickSort {

	private static int partition(int arr[], int left, int right)

	{

		int i = left, j = right;

		int tmp;

		int pivot = arr[(left + right) / 2];

		while (i <= j) {

			while (arr[i] < pivot)

				i++;

			while (arr[j] > pivot)

				j--;

			if (i <= j) {

				tmp = arr[i];

				arr[i] = arr[j];

				arr[j] = tmp;

				i++;

				j--;

			}

		}
		;

		return i;

	}

	private static void quickSort(int arr[], int left, int right) {

		int index = partition(arr, left, right);

		if (left < index - 1)

			quickSort(arr, left, index - 1);

		if (index < right)

			quickSort(arr, index, right);

	}

//	private static void quick_sort(int[] arr, int start, int end) {
//		if (start < end) {
//			int pivotIndex = pivot(arr, start, end);
//			quick_sort(arr, start, pivotIndex - 1);
//			quick_sort(arr, pivotIndex + 1, end);
//		}
//	}
//
//	private static int pivot(int[] arr, int start, int end) {
//		int pivotIndex = start;
//		int pivotValue = arr[pivotIndex];
//		for (int i = start + 1; i <= end; i++) {
//			if (pivotValue > arr[i]) {
//				pivotIndex++;
//				int temp = arr[pivotIndex];
//				arr[pivotIndex] = arr[i];
//				arr[i] = temp;
//			}
//		}
//		int temp = arr[pivotIndex];
//		arr[pivotIndex] = arr[start];
//		arr[start] = temp;
//		return pivotIndex;
//	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, n - 1);
		printArray(arr);
		sc.close();
	}

}
