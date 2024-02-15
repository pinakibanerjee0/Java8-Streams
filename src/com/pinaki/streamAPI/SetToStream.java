package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SetToStream {

	/*
	 * 
	 * Using Collection.stream(): This method involves directly converting the Set
	 * to Stream using Collection.stream() method.
	 * 
	 */

	private static <T> Stream<T> convertSetToStream(Set<T> set) {
		return set.stream();
	}

	/*
	 * 
	 * 
	 * Using Predicate to filter the Stream: In this method filter(Predicate) method
	 * is used that returns a stream consisting of elements that match the given
	 * predicate condition. The Functional Interface Predicate is defined in the
	 * java.util.Function package and can therefore be used as the assignment target
	 * for a lambda expression or method reference. It improves manageability of
	 * code, helps in unit-testing them separately Algorithm:
	 * 
	 * Get the Set to be converted. Define the Predicate condition by either using
	 * pre-defined static methods or by creating a new method by overriding the
	 * Predicate interface. In this program, the interface is overridden to match
	 * the strings that start with “G”. Convert Set to Stream. This is done using
	 * Set.stream(). Filter the obtained stream using the defined predicate
	 * condition The required Stream has been obtained. Return/Print the Stream.
	 */

	// Generic function to convert a set to stream
	private static <T> Stream<T> convertSetToStream(Set<T> set, Predicate<T> predicate) {
		return set.stream().filter(predicate);
	}

	// Main method
	public static void main(String args[]) {
		// Create a set of String
		Set<Integer> setOfInteger = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));

		// Print the set of Integer
		System.out.println("Set of Integer: " + setOfInteger);

		// Convert Set of Stream
		Stream<Integer> streamOfInteger = convertSetToStream(setOfInteger);

		// Print the Stream of Integer
		System.out.println("Stream of Integer: " + Arrays.toString(streamOfInteger.toArray()));

		// Create a set of String
		Set<String> setOfString = new HashSet<>(Arrays.asList("GeeksForGeeks", "A computer portal", "for", "Geeks"));

		// Print the set of String
		System.out.println("Set of String: " + setOfString);
		// Create the predicate for item starting with G
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String s) {
				// filter items that start with "G"
				return s.startsWith("G");
			}
		};

		// Convert Set of Stream
		Stream<String> streamOfString = convertSetToStream(setOfString, predicate);

		// Print the filter Stream of String
		System.out.println("Stream from List with items" + " starting with G: ");

		System.out.println(Arrays.toString(streamOfString.toArray()));

	}
}
