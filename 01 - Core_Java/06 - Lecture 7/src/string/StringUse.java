package string;

public class StringUse {
	
	public static void print(String s) {
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	public static void printPrefix(String str) {
		for(int i = 1; i <= str.length(); i++) {
			System.out.println(str.substring(0, i));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sp = "abcde";
		printPrefix(sp);
		
		
		
//		char c = 'c';
//		String str = "abcdefgh"; // internally stored in the form of character array
//		// str is a reference to the memory where the string is stored
//		System.out.println(str);
//		// print(str);
//		str = "abc"; // str is now refencing to "abc"
//		System.out.println(str);
//		String s = "abc";
//		System.out.println(s);
//		
//		/*
//		 * Strings in java are IMMUTABLE
//		 * str.charAt(1) = 'f'; This statement is invalid. 'b' will not become 'f'
//		 * 
//		 * There is a concept in java called String Pool
//		 * Whenever we create a new String / character array, the String variable first searches if the string is already available in the String Pool
//		 * If it is present then the String variable refers to that string rather than creating a new string
//		 * If it is not present, then a new string is created in the  String Pool and the String variable then refers to it
//		 * 
//		 * In the above case "abc" is already created in the String Pool by the time s is trying to refer to it
//		 * So, now as "abc" is present in the String Pool, so, s will refer to it rather than creating a new String
//		 * So, both str and s are referring to the same String in the String Pool
//		 * Now, if Strings were not immutable in java and we could change any character in the string as we deemed necessary
//		 * then for a change made for str will also change s. Which is something we do not want.
//		 * That is the reason why Strings are immutable in java
//		 * 
//		 * It is known as String Pool optimization
//		 */
//		
//		// Concatenation
//		str = str + "def"; // a new string is created by concatenating str and "abc"
//		System.out.println(str);
//		System.out.println(str.concat("ghi")); // concat() only returns the new created string but does not change the original string
//		System.out.println(str);
//		
//		// Compare to Strings
//		int[] arr1 = {1, 2, 3};
//		int[] arr2 = {1, 2, 3};
//		if(arr1 == arr2) { // the arrays are not compared. Only their addresses are compared. Which is not equal as both are different arrays		
//			System.out.println("equal"); // this will not be executed
//		} else {
//			System.out.println("unequal"); // this will be executed
//		}
//		
//		arr2 = arr1; // arr2 is now referring to the array whose address is stored in arr1. So, arr2 is storing the value which is stored in arr1
//		if(arr1 == arr2) {		
//			System.out.println("equal"); // this will be executed as both arr1 and arr2 refer to the same address.
//		} else {
//			System.out.println("unequal"); // this will not be executed
//		}
//		
//		String str1 = "abc";
//		String str2 = "abc";
//		if(str1 ==  str2) { // str1 and str2 refer to the same String in String Pool. So, the address of the String Pool that is stored in them is compared
//			System.out.println("equal"); // this will be executed
//		} else {
//			System.out.println("unequal"); // this will not be executed
//		}
//		
//		/*
//		 * Whenever we are trying to compare Strings, we should not compare their addresses rather the data stored in them
//		 * because the String Pool optimization might not always work
//		 */
//		if(str1.equals(str2)) {
//			System.out.println("equal"); // this will be executed
//		} else {
//			System.out.println("unequal"); // this will not be executed
//		}
//		
//		
//		
//		str = "abcdefgh";
//		
//		// Access a element in aparticular address
//		System.out.println(str.charAt(1)); // access a particular index in string. 
//		/*
//		 * str[index] is not allowed
//		 * We need to use str.charAt(index);
//		 */
//		
//		// Length of the string
//		// str.length()
//		System.out.println(str.length());
//		
//		// substring
//		// str.substring(beginIndex, endIndex)
//		System.out.println(str.substring(2, 5)); // from index 2 to (5 - 1) = 4 i.e, start to n - 1
//		System.out.println(str.substring(2)); // start to n - 1
//		System.out.println(str.substring(str.length())); // empty string will print as there is a null character at the end of the string.
//		// Anything after that does not exist so, that will give index out of bound error
//		String temp = str.substring(str.length());
//		System.out.println(temp.length()); // 0
//		System.out.println(str.substring(1, 1)); // empty string as there there is no string between 1 to (1 - 1) = 0
//		s = str.substring(4, 7);
//		System.out.println(s); // efg
//		System.out.println(s.length()); // 3
//		
//		// check character sequence contained or not
//		// str.contains(charSequence)
//		System.out.println(str.contains("cde")); // true
//		System.out.println(str.contains("cdf")); // false
		
		
		
	}

}
