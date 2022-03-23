package generics;

public class PairUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<Integer> p = new Pair<Integer>(1, 2); // Here, T is of type Integer
		p.setFirst(10);;
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
		
		Pair<String> p2 = new Pair<String>("ab", "cd"); // Here, T is of type String
		p2.setFirst("def");
		String s = p2.getFirst();
		System.out.println(s);
		
		Pair<Character> p3 = new Pair<>('a', 'c'); // in the newer version of Java, we don't need to define the class in <> both time. Only at the first is enough
		
//		Pair p4 = new Pair(1, 2); // here T is of type Object class. It's a bad practice. But now, we can use any class for type T
		
		// Multiple Generics
		PairMultiple<Integer, String> p5 = new PairMultiple<>(1, "abc"); // Now, T is of type Integer class and V is of type String class
		
		// we can also create a genric class with more than two generics
		
		// GENERIC INCEPTION(IMO ;))
		int a = 10;
		int b= 12; 
		int c = 23;
		PairMultiple<Integer, Integer> internalPair = new PairMultiple<>(a, b);
		PairMultiple<PairMultiple<Integer, Integer>, Integer> p6 = new PairMultiple<>(internalPair, c);
		
		System.out.println(p6.getFirst().getFirst()); // 10
		System.out.println(p6.getFirst().getSecond()); // 12
		System.out.println(p6.getSecond()); // 23
		
	}

}
