package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ConvertListToStream {

	/*
	 * 
	 * Using List.stream() method
	 */

	// Generic function to convert a list to stream
	private static <T> Stream<T> convertListToStream(List<T> list) {
		return list.stream();
	}

	/*
	 * 
	 * 2. Filter Stream using a Predicate: The Functional Interface Predicate is
	 * defined in the java.util.Function package and can therefore be used as the
	 * assignment target for a lambda expression or method reference. It improves
	 * manageability of code, helps in unit-testing them separately Algorithm:
	 * 
	 * 1. Get the Stream , 2. Define the Predicate condition by either using
	 * pre-defined static methods or by creating a new method by overriding the
	 * Predicate interface. In this program, the interface is overridden to match
	 * the strings that start with “G”. 3. Convert Stream into List using
	 * List.stream() method. 4. Filter the obtained stream using the defined
	 * predicate condition 5. The required Stream has been obtained. Hence Print the
	 * filtered elements of the Stream using forEach() method. It can also be
	 * returned as required.
	 * 
	 */

	public static void main(String args[]) {

		// Create a stream of integers
		List<String> list = Arrays.asList("GeeksForGeeks", "A computer portal", "for Geeks");

		// Print the List
		System.out.println("List: " + list);

		// Convert List to stream
		Stream<String> stream = convertListToStream(list);

		// Print the Stream
		System.out.println("Stream from List: " + Arrays.toString(stream.toArray()));

		// Create the predicate for item starting with G
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String s) {
				// filter items that start with "G"
				return s.startsWith("G");
			}
		};

		System.out.println("Stream from List with items" + " starting with G: ");

		// Convert List to stream
		list.stream().filter(predicate).forEach(System.out::println);
	}
}
