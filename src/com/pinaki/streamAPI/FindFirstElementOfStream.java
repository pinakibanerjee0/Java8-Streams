package com.pinaki.streamAPI;

import java.util.stream.Stream;

public class FindFirstElementOfStream {

	/*
	 * Input: Stream = {“Geek_First”, “Geek_2”, “Geek_3”, “Geek_4”, “Geek_Last”}
	 * Output: Geek_First
	 * 
	 * Input: Stream = {1, 2, 3, 4, 5, 6, 7} Output: 1
	 */

	/*
	 * 
	 * Using Stream.reduce() Method: The reduce method works on two elements in the
	 * stream and returns the element as per the required condition. Therefore this
	 * method can be used to reduce the stream so that it contains only the first
	 * element. Approach:
	 * 
	 * 1. Get the stream of elements in which the first element is to be returned.
	 * 2. To get the first element, you can use the reduce() method to ignore the
	 * second element, repeatedly, till there is no second element.
	 * Stream.reduce((first, second) -> first) 3. This reduces the set of elements
	 * in a Stream to a single element, which is first. 4. Hence the only single
	 * element will be remain in the stream which is the first element.
	 */

	// first_elements in a Stream
	public static <T> T firstElementInStream(Stream<T> stream) {
		T first_element = stream

				// reduce() method reduces the Stream
				// to a single element, which is first.
				.reduce((first, second) -> first)

				// if stream is empty
				// null is returned
				.orElse(null);

		return first_element;
	}

	/*
	 * Method 2: Using Stream findFirst() Method: The findFirst() method will
	 * returns the first element of the stream or an empty if the stream is empty.
	 */

	public static <T> T findFirst(Stream<T> stream) {
		T first_element = stream

				// findFirst() method returns
				// the first element of stream
				.findFirst()

				// if stream is empty
				// null is returned
				.orElse(null);

		return first_element;
	}

	// Driver code
	public static void main(String[] args) {

		Stream<String> stream = Stream.of("Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");

		// Print the first element of a Stream
		System.out.println("First Element: " + firstElementInStream(stream));

		Stream<String> stream2 = Stream.of("Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");

		System.out.println("First Element using findFirst() : " + findFirst(stream2));
	}
}
