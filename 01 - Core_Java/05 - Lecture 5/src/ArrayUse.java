
public class ArrayUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Array is contiguous. The elements are placed in consecutive memory places
		 */
		int arr[] = new int[10]; // datatype array-name[] = memory-allocating-keyword datatype[size]; (0 to size - 1)
		/*
		 * arr[n] is the nth index of the array arr
		 * if n > size - 1, then we will get exception, ArrayIndexOutOfBound. It's an error that gives SIGSEV or NZEC
		 * array index cannot be negative
		 * When array is created, by default the all indices in the array is default to zero.
		 */
		arr[3] = 15;
		System.out.println(arr[3]); // 15
		System.out.println(arr[0]); // 0
		System.out.println(arr[1]); // 0
		
		int n = 10;
		int arr2[] = new int[n];
		
		char chArray[] = new char[11]; // All the indices are initialized to null(blank) as the character for zero is null
		System.out.println(chArray[0]); 
		
		double dArray[] = new double[12]; // All the indices are initialized to 0.0 as the double of zero is 0.0
		System.out.println(dArray[0]);
		
		boolean boolArray[] = new boolean[5]; // Whenever an boolean array is created, all elements are initialised to false.
		System.out.println(boolArray[0]);
		

	}

}
