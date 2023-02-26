package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
	public static void main(String[] args) {
		
		// Q) Create a List and Filter all even numbers from list
		
		
		List<Integer> list1 = List.of(2,3,50,21,22,67); //unmodifiable/immutable list
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(12);
		list2.add(34);
		list2.add(23);
		list2.add(78);
		
		List<Integer> list3 = Arrays.asList(23, 567, 12, 677, 24); //unmodifiable/immutable list
		
		//list1
		//without stream
		List<Integer> listEven = new ArrayList<>();
		for(Integer i : list1) {
			if(i%2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println(list1);
		System.out.println(listEven);
		
		
		//using stream
		//get stream from list1
		//We can use the stream() function to get the stream object from any collection
		//Stream  is an interface
		Stream<Integer> stream = list1.stream();
		
		//now we can perform bulk operations on the stream
		//We can pass a Class, a anonymous class or a lambda as Predicate to the filter and any element that returns True for the Predicate will be included in the filtered stream.
		//Once filtered stream is created, we need to collect them to a List as values are filtered.
		List<Integer> newList = stream.filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(newList);
		
		//method chaining in stream api
		List<Integer> newList2 = list1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(newList2);
		
		
		//Q) elements that are greater than 10
		List<Integer> newList3 = list1.stream().filter(i->i>10).collect(Collectors.toList());
		System.out.println(newList3);
		
	}
}
