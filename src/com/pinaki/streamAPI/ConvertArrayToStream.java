package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArrayToStream {
	/*
	 * 
	 * 1.Using Arrays.stream(): Algorithm:
	 * 
	 * Get the Array to be converted. Convert the array into Stream using
	 * Arrays.stream() method by passing the array as the parameter. Return the
	 * formed StreamUsing Arrays.stream():
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Array to be converted. 2. Convert the array into Stream using
	 * Arrays.stream() method by passing the array as the parameter. 3. Return the
	 * formed Stream
	 * 
	 */

	public static <T> Stream<T> convertArrayToStream(T array[]) {

		// Return the converted Stream
		return Arrays.stream(array);
	}

	/*
	 * 
	 * Using Stream.of(): Stream.of() method creates a Stream directly with the
	 * values or collection passed as the parameter.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Array to be converted. 2. Convert the array into Stream using
	 * Stream.of() method by passing the array as the parameter. 3. Return the
	 * formed Stream Program:
	 */

	public static <T> Stream<T> convertArrayToStreamUsingOf(T array[]) {

		// Return the converted Stream
		return Stream.of(array);
	}

	/*
	 * Using List.stream(): This is an indirect method in which the array is first
	 * converted into a List using Arrays.asList() method. Then the formed list is
	 * converted into a Stream using List.stream() method.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Array to be converted. 2. Convert the array into List using
	 * Arrays.asList() method by passing the array as the parameter. 3. Convert the
	 * formed List into Stream using List.stream() method. 4. Return the formed
	 * Stream
	 * 
	 */

	public static <T> Stream<T> convertArrayToStreamUsingListStream(T array[]) {

		// Return the converted Stream
		return Arrays.asList(array).stream();
	}

	public static void main(String args[]) {
		// Create an Array
		String array[] = { "Geeks", "forGeeks", "A Computer Portal" };

		// Print the Array
		System.out.println("Array: " + Arrays.toString(array));

		// convert the Array to Stream
		Stream<String> stream = convertArrayToStream(array);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(stream.toArray()));

		// convert the Array to Stream
		stream = convertArrayToStreamUsingOf(array);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(stream.toArray()));

		// convert the Array to Stream
		stream = convertArrayToStreamUsingListStream(array);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(stream.toArray()));

		// ****** convert Primitive Array to Stream in Java **********
		// ************************************************************

		// Create an Array
		int[] arr = new int[] { 3, 2, 5, 4, 1 };

		// Print the Array
		System.out.println("Array: " + Arrays.toString(arr));
		// convert the Array to Stream
		IntStream strm = Arrays.stream(arr);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(strm.toArray()));

		// Using IntStream.of(): The IntStream.of() method creates a Stream directly
		// with the primitive values or collection passed as the parameter.

		// convert the Array to Stream
		strm = IntStream.of(arr);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(strm.toArray()));
	}
}
