package operators;

public class BitWise {

	public static void main(String[] args) {
		
		// Bitwise Operators:
		System.out.println(2 & 3); // Bitwise AND: 2
		System.out.println(2 | 3); // Bitwise OR 3
		System.out.println(2 ^ 3); // Bitwise XOR: 1
		System.out.println(~42); // Bitwise NOT: -43
		
		
		// Shifting Operators:
		
		// Left Shift : << : Left most bit gets dropped and a zero is padded at the right side
		// 1011 << 1 => 0110
		// 0110 << 1 => 1100
		// 1011 << 2 => 1100
		// Generally, for each left shift the number is multiplied with 2
		System.out.println(34 << 1); // 68
		System.out.println(-4 << 1); // -8
		
		// Right Shift: >> : right most bit gets dropped but the padding on the left depends
		// Id number was positive then padding will be zero. But for negative numbers padding will be one. To keep the sign same
		// 1011 >> 1 => 0101
		// Generally, for each right shift the number is divided by 2. 
		// Just opposite of left shift
		System.out.println(34 >> 1); // 17
		System.out.println(-4 >> 1); // -2
		
		
		// Increment Decrement Operators:
		
		// Post-Increment Operator
		int a1 = 10;
		int b1 = a1++; // value of a increases after assigning. So, value of b remains 10 but a increases
		System.out.println(a1); // 11
		System.out.println(b1); // 10
		
		// Pre-Increment
		int a2 = 10;
		int b2 = ++a2; // value of a increases before assigning. So, value of a becomes 11 when assigning to b
		System.out.println(a2); // 11
		System.out.println(b2); // 11
		
		// Post-Decrement
		int a3 = 10;
		int b3 = a3--; // value of a decreases after assigning. So, value of b remains 10 but a decreases
		System.out.println(a3); // 9
		System.out.println(b3); // 10
		
		// Pre-Decrement
		int a4 = 10;
		int b4 = --a4; // value of a decreases before assigning. So, value of a becomes 9 when assigning to b
		System.out.println(a4); // 9
		System.out.println(b4); // 9
		
		
		// Shortcuts:
		// int a = 10;
		// a+=1;
		// a-=1;
		// a*=2;
		// a/=2;
		// a^=2;
	}

}
