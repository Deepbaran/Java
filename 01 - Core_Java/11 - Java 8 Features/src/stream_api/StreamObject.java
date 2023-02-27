package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {
		
		//Stream API - collection process
		//collection / group of object

		//We can get stream from Array also: Arrays.stream(newArr);
		
		//1 - blank
		Stream<Object> emptyStream = Stream.empty();
		
		//2 - array, object, collection
		String[] names = {"Deep","baran","Kar"};
		
		Stream<String> stream1 = Stream.of(names);
		//For forEach, unlike filter where we pass a Predicate, we need to pass a consumer.
		//consumer is that method that does not return anything
		stream1.forEach(e -> {
			System.out.println(e);
		});
		
		//3 - builder pattern
		Stream<Object> streamBuilder = Stream.builder().build();
		
		
		//4 - Arrays method
		//We are passing an anonymous class to stream() method to get a stream from it
		//By default, integer Arrays give IntStream, to convert it to Stream object we need to explicitly convert it
		//But it is recommended to use IntStream because,
		//Stream<Integer> operates on boxed values ( Integer instead of primitive int) which takes significantly more memory and usually a lot of boxing/unboxing operations (depending on your code), whereas IntStream works with primitives.
		IntStream stream = Arrays.stream(new int[] {2,4,65,3,564});
		//Stream stream = (Stream) Arrays.stream(new int[] {2,4,65,3,564});
		stream.forEach(e -> System.out.println(e));
		
		//5 - List, Set
		List<Integer> list2 = new ArrayList<>();
		list2.add(12);
		list2.add(34);
		list2.add(23);
		list2.add(78);
		Stream<Integer> stream2 = list2.stream();
		stream2.forEach(e -> System.out.println(e));
		
	}

}
