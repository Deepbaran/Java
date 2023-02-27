package stream_api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {

	public static void main(String[] args) {
		
		//filter(Predicate)
			//Predicate - boolean valued function
			//stream will collect if Predicate is returning true, otherwise leave it
			//e -> {return true;} => e -> e>10
		
		//map(Function)
		/*
		 	each element operation
		 	map will mutate each value in the stream according to the value returned by Function if we passed that element to Function as argument.
		 */
		
		//forEach(Consumer)
			//Consumer - It is a method that does not return anything
			//Traverse over each element and perform some operations
			//It does not return anything
		
		List<String> names = List.of("Aman","Ankit","Arnab","Deep");
		List<String> newNames = names.stream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
		System.out.println(newNames);
		
		List<Integer> numbers = List.of(23,4,2,5,7,4);
		List<Integer> newNumbers = numbers.stream().map(i->i*i).collect(Collectors.toList());
		System.out.println(newNumbers);
		
		names.stream().forEach(e -> System.out.println(e));
		newNames.stream().forEach(System.out::println); //We are passing the reference of the println method directly [Method reference]
		
		//sort
		//sorted() method sorts the stream [We can pass comparator for custom sorting in sorted()]
		//using forEach on top of the sorted stream
		numbers.stream().sorted().forEach(System.out::println);
		
		//min(Comparator)
			//Comparator - This method defines which logic to use when comparing the elements
		//get() method is used to get the minimum element from the stream according to the comparator
		//without get() min and max returns Optional
		Integer integer1 = numbers.stream().min((x,y) -> x.compareTo(y)).get();
		System.out.println(integer1);
		
		//max(Comparator)
		Integer integer2 = numbers.stream().max((x,y) -> x.compareTo(y)).get();
		System.out.println(integer2);
	}

}
