package lambda_expressions;

public class Mian {

	public static void main(String[] args) {
		System.out.println("My System starts..");
		
//		MyInter myInter = new MyInterImpl();
//		myInter.sayHello();
		
		
		// anonymous class
		// Although it looks absurd, but what is basically happening is that we are creating a child class of MyInter interface that implements the sayHello method.
//		MyInter i = new MyInter() {
//
//			@Override
//			public void sayHello() {
//				System.out.println("this is first anonymous class");
//			}
//			
//		}
//		i.sayHello();
//		
//		MyInter i2 = new MyInter() {
//
//			@Override
//			public void sayHello() {
//				System.out.println("this is second anonymous class");
//			}
//			
//		}
//		i2.sayHello();
		
		
		// using our interface with the help of Lambda expression
		// Lambda is automatically returning a child of the MyInter interface [implementing it] while overwriting the single abstract method it had. This is the reason we need Functional Interface for Lambda nothing else.
		// Lambda can ONLY be used for Functional Interface
		// Using Lambda we are providing implementation for the abstract function in the interface.
		// If two methods are there in the interface instead of two (Not a Funtional Interface) then we cannot use Lambda, we need to use anonymous class.
		MyInter i = () -> {
			System.out.println("this is the first time i am using lambda");
		};
		i.sayHello();
		
		MyInter i2 = () -> System.out.println("this is the second time i am using lambda");
		i2.sayHello();		
		
		
		SumInter sumInter = (int a, int b) -> {
			return a+b;
		};
		System.out.println(sumInter.sum(2, 6));
		System.out.println(sumInter.sum(4, 7));
		
		SumInter sumInter2 = (a, b) -> a+b; //compiler infers the type of a and b
		System.out.println(sumInter2.sum(2, 6));
		System.out.println(sumInter2.sum(4, 7));
	}

}
