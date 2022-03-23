package stream_api;

import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {
	public static void main(String[] args) {
		// Stream Methods
		
		// filter(predicate)
		List<String> names = List.of("Deep", "baran", "Kar");
		List<String> newNames = names.stream().filter(e -> e.startsWith("D")).collect(Collectors.toList());
		System.out.println(newNames);
		
		// map(function)
		List<Integer> numbers = List.of(23, 4, 2, 5, 7, 4);
		List<Integer> newNumbers = numbers.stream().map(e -> e * e).collect(Collectors.toList());
		System.out.println(newNumbers);
		
		// forEach()
		names.stream().forEach(e -> {
			System.out.println(e);
		});
		newNames.stream().forEach(System.out::println); 
		// Here we are passing the method reference to forEach(). 
		// println is a method declared in the PrintStream Class and out is the PrintStream object that is declared in the System class.
		// The double colon (::) operator, also known as method reference operator in Java, is used to call a method by referring to it with the help of its class directly. 
		// They behave exactly as the lambda expressions. 
		// The only difference it has from lambda expressions is that this uses direct reference to the method by name instead of providing a delegate to the method.
		
		// sorted()
		numbers.stream().sorted().forEach(System.out::println);
		
		// min()
		Integer minNumber = numbers.stream().min((x,y) -> x.compareTo(y)).get();
		System.out.println(minNumber);
		
		// max()
		Integer maxNumber = numbers.stream().max((x,y) -> x.compareTo(y)).get();
		System.out.println(maxNumber);
	}
}  