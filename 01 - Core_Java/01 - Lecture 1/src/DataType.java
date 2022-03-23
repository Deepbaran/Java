
public class DataType {

	public static void main(String[] args) {
		char c = 'a';
		System.out.println('a' + 3); // 'a' => 97. 'a' + 3 => 97 + 3 = 100
		// + is defined for numbers and not for characters. So, + is converting 'a' to ascii value and adding it to 3, and we receive 100
		
		int i = c + 10; // c + 10 => 'a' + 10 => 97 + 10 = 107
		System.out.println(i);
		
//		char abc = i; // 4 bytes(int) cannot be stored in 2 bytes(char)
		// copying char to int is alright but vice versa is not ok
		// We can typecast one type of datatype only to a datatype which has bigger data size than the actual datatype
		
//		double d = i; // ok
//		i = d; // not ok
		
		// by default all decimal numbers are treated as double(8 bytes) by sysytem
		float f = 1.23f; 
		// 1.23 is by default double. By writing f at the end of 1.23, it is treated as float
		
		int a = 10;
		double d = a; // implicit typecaseting <- compiler automatically typecasts
//		typecast one type of datatype only to a datatype which has bigger data size than the actual datatype
//		Automatic type conversion in Java takes place when :
//		two type are comptible and size of destination is larger than source type
		
		long lg = 1238665547864487865L; // We need to ass L at the end of every long if it's too big 
		// to fit in the last 4 bytes(default bytes or integer range)
		// Otherwise compiler give an error
		int b = (int)lg; // explicit typecasting
		System.out.println(lg); // 1238665547864487865
		System.out.println(b); // -939903047 <- last four bytes of lg and the first bit is 1, so we are getting negative
		// Only the last 4 bytes of the long from the original 8 bytes is copied to b. So, the number is completely different
		// The last 4 bytes are the default 4 bytes
		
		char ch = (char)97; // 'a'
		System.out.println(ch);
		
		// Negative numbers are stored as 2's complement
	}

}
