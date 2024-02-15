package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatteningNestedCollections {

	/*
	 * 
	 * Consider the below illustration where we have an array including 3 arrays but
	 * after the flattening effect, we will have one result array with all the
	 * elements in three arrays.
	 *
	 * Input : arr1[] = {{1,2,3,4},{5,6,7},{8,9}}; Processing : Flattening Output :
	 * arr1[] = {1,2,3,4,5,6,7,8,9};
	 * 
	 * Stream flatMap() method is used to flatten a Stream of collections to a
	 * stream of objects. The objects are combined from all the collections in the
	 * original stream. The flatMap() method is a one-to-many transformation to the
	 * elements of the stream and then flattening the resulting elements into a new
	 * stream. Basically Stream.flatMap() method helps to convert
	 * Stream<Collection<T>> to the Stream<T>.
	 */

	// Method 1
	// To flatten a map containing a list of items as values
	public static <T> Stream<T> flatten(Collection<List<T>> values) {

		// Stream.flatMap() method converts
		// Stream<Collection<T>> to the Stream<T>
		Stream<T> stream = values.stream().flatMap(x -> x.stream());

		// Return the desired stream
		return stream;
	}

	// To flatten a stream of two arrays of the same type
	public static <T> Stream<T> flatten(T[] a, T[] b) {
		// Stream.flatMap() method converts
		// Stream<Collection<T>> to the Stream<T>
		Stream<T> stream = Stream.of(a, b).flatMap(Arrays::stream);

		// Returns the desired stream
		return stream;
	}

	// Method 2
	// Main driver method
	public static void main(String[] args) {

		// Creating an object of Map class
		// Declaring object of integer and string type
		Map<Integer, List<String>> map = new HashMap<>();

		// Adding elements to the above Map object
		// Custom input entries
		map.put(1, Arrays.asList("1", "2", "3"));
		map.put(2, Arrays.asList("4", "5", "6"));

		// Creating a List class object holding all elements
		// after flattening
		List<String> s = flatten(map.values()).collect(Collectors.toList());

		// Print and display the above List object
		System.out.println(s);

		// Array 1 has uppercase characters
		String[] a = { "A", "B", "C" };

		// Array 2 has lowercase characters
		String[] b = { "i", "J", "K" };

		// Calling the above method in the main() method
		String[] x = flatten(a, b).toArray(String[]::new);

		// Return string representation of contents
		// of integer array
		System.out.println(Arrays.toString(x));
	}
}
