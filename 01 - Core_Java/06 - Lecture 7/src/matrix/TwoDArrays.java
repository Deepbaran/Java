package matrix;

public class TwoDArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * JAGGED ARRAYS: 2D arrays with variable row length are called Jagged Arrays. 
		 * i.e, each row will have different column size (different length of 1D arrays)
		 */
		
		int[][] arr = new int[3][5];
		System.out.println(arr[0]);
		
		int arr2[][] = new int[4][]; // a 2d array with 4 rows is created which will have variable columns
		// here each of the 4 1D array will have variable size
		// master array is of size 4
		// No 1D array is created so far. Only the master array is created
//		System.out.println(arr2[0]); // null as no 1D array is being referred
////		System.out.println(arr2[0][0]); // null pointer exception
		for(int i = 0; i < arr2.length; i++){
			arr2[i] = new int[i + 2]; // a new 1D array is created and it's memory is stored in the ith index of the master array where arr2 is referring to
		}
//		System.out.println(arr[0][0]); // 0
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j++){
				System.out.print(arr2[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
