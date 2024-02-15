package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertStreamToArray {

	/*
	 * Using toArray(): Stream provides toArray() method that returns an array
	 * containing the elements of the stream in the form of Object array. Syntax:
	 */

	// Function to convert Stream to Array
	public static <T> Object[] convertStreamToArray(Stream<T> stream) {
		return stream.toArray();
	}

	/*
	 * 
	 * Using toArray(IntFunction generator):
	 * 
	 * This method returns an array containing the elements of this stream, using
	 * the provided generator function to allocate the returned array, as well as
	 * any additional arrays that might be required for a partitioned execution or
	 * for resizing. Syntax:
	 * 
	 * <A> A[] toArray(IntFunction<A[]> generator) Algorithm:
	 * 
	 * 1 Get the Stream Convert Stream into an Array using Stream.toArray() method
	 * by passing Object[]::new as the generator function to allocate the returned
	 * array. The obtained array is of type Object[] Return the Array Object[]
	 */

	// Function to convert Stream to Array
	public static <T> Object[] convertStreamToArray2(Stream<T> stream) {
		return stream.toArray(Object[]::new);
	}

	/*
	 * 
	 * Stream to int[] using mapToInt(): Java 8 Stream API provides mapToInt()
	 * method that returns an IntStream consisting of the results of applying the
	 * given function to the elements of this stream. This is an intermediate
	 * operation. The obtained IntStream is then converted into int[] using
	 * toArray(). Algorithm:
	 * 
	 * Get the Stream of Integers Convert Stream into an IntStream using
	 * Stream.mapToInt() method. Convert the obtained IntStream into int[] using
	 * toArray() The obtained array is of type Integer Return the Array int[]
	 */

	// Function to convert Stream to Array
	public static int[] convertStreamToArray3(Stream<Integer> stream) {
		return stream.mapToInt(Integer::intValue).toArray();
	}

	public static void main(String args[]) {
		// Create a stream of integers
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

		// Convert Stream to array
		Object[] array = convertStreamToArray(stream);

		// Print the array of stream
		System.out.println("Array from Stream: " + Arrays.toString(array));

		// Create a stream of integers
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);

		// Convert Stream to array
		Object[] array2 = convertStreamToArray2(stream2);

		// Print the array of stream
		System.out.println("Array from Stream 2 : " + Arrays.toString(array2));

		// Create a stream of integers
		Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

		// Convert Stream to array
		int[] array3 = convertStreamToArray3(stream3);

		// Print the array of stream
		System.out.println("Array of Integer from Stream: " + Arrays.toString(array3));
	}
}
