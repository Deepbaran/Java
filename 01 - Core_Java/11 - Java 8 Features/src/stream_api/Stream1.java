package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		// Create a List and Filter all even numbers from list

		List<Integer> list1 = List.of(2, 4, 50, 21, 22, 67); // List created by List.of() creates a immutable list.

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(12);
		list2.add(34);
		list2.add(23);
		list2.add(78);

		List<Integer> list3 = Arrays.asList(23, 567, 12, 677, 24); // List created by Arrays.asList() creates a
																	// immutable list.

		// list1
		// Without Stream
		List<Integer> listEven = new ArrayList<Integer>();

		for (Integer i : list1) {
			if (i % 2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println(list1);
		System.out.println(listEven);

		// Using Stream
//		Stream<Integer> stream = list1.stream(); // Stream is an interface
//		List<Integer> newList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());

		List<Integer> newList = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(newList);

		// Create a List and Filter all numbers from list that are bigger than 10
		// list1
//		List<Integer> newList1 = list1.stream().filter(i -> i > 10).collect(Collectors.toList());
//		System.out.println(newList1);
		list1.stream().filter(i -> i > 10).forEach(i -> System.out.print(i + " "));
		System.out.println();

	}

}
