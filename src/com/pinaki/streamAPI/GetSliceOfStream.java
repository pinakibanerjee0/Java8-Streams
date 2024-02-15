package com.pinaki.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetSliceOfStream {
	/*
	 * 
	 * Slice of a Stream means a stream of elements that exists in a specified
	 * limit, from the original stream.
	 * 
	 * Examples:
	 * 
	 * Input: [11, 12, 13, 14, 15, 16, 17, 18, 19, 20] Output: [15, 16, 17, 18, 19]
	 * Explanation: The output contains a slice of the stream from index 4 to 8.
	 * 
	 * Input: [1, 2, 3, 4, 5, 6, 7, 8, 9] Output: [2, 3, 4] Explanation: The output
	 * contains a slice of the stream from index 1 to 3.
	 */

	/*
	 * Method 1 : Using skip() and limit(): Stream API in Java provides skip()
	 * method which is used to discard the other non-required elements from the
	 * stream. It also provides limit() function which is applied to fetch the new
	 * stream with the specified index as limit, in the encountered order.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Stream to be sliced. 2. Get the From and To index to be sliced
	 * from Stream as StartIndex and EndIndex 3. Call skip() method to specify the
	 * number of elements to be skipped before the starting index as
	 * skip(startIndex) 4. Call limit() method to specify the number of elements,
	 * from the stream, that should be limited as limit(endIndex – startIndex + 1)
	 * 5. Return the Sliced Stream
	 * 
	 */

	// Stream from startIndex to endIndex
	public static <T> Stream<T> getSliceOfStream(Stream<T> stream, int startIndex, int endIndex) {
		return stream
				// specify the number of elements to skip
				.skip(startIndex)

				// specify the no. of elements the stream
				// that should be limited
				.limit(endIndex - startIndex + 1);
	}

	/*Method 2 :
	 * 
	 * Using Collectors along with skip() and limit(): In this method, the Stream is
	 * converted to List and then a function of a collector to get sub-list of
	 * desired elements is used and the sub-list id converted back to a stream using
	 * stream.collect(Collectors.collectingAndThen()). Algorithm:
	 * 
	 * 1. Get the Stream to be sliced. 2. Get the From and To index to be sliced
	 * from Stream as StartIndex and EndIndex Using Collectors.collectingAndThen, 3.
	 * Convert the Stream to List using Collectors.toList() 4. Obtain the Stream
	 * from the List as list.stream() 5. Call skip() method to specify the number of
	 * elements to be skipped before the starting index as skip(startIndex) 6.Call
	 * limit() method to specify the number of elements, from the stream, that
	 * should be limited as limit(endIndex – startIndex + 1) 7.Collect the sliced
	 * list stream using stream.collect() 8.Return the Sliced Stream
	 * 
	 */

	// Stream from startIndex to endIndex
	public static <T> Stream<T> getSliceOfStream2(Stream<T> stream, int startIndex, int endIndex) {
		return stream.collect(Collectors.collectingAndThen(

				// 1st argument
				// Convert the stream to list
				Collectors.toList(),

				// 2nd argument
				list -> list.stream()
						// specify the number of elements to skip
						.skip(startIndex)

						// specify the no. of elements the stream
						// that should be limited
						.limit(endIndex - startIndex + 1)));
	}

	/*Method 3 :
	 * 
	 * Fetching a SubList: This method involves converting a Stream into a List. Now
	 * this list is used to fetch a required subList from it between the specified
	 * index. And finally, this subList is converted back to Stream. Algorithm:
	 * 
	 * 1. Get the Stream to be sliced. 2. Get the From and To index to be sliced
	 * from Stream as StartIndex and EndIndex 3. Convert the Stream to List using
	 * Collectors.toList() and then collect it using stream.collect() 4. Fetch the
	 * subList from the collected List with the startIndex and endIndex+1 as the
	 * limit using subList(startIndex, endIndex + 1) 5. Convert the subList back to
	 * stream using stream() 6. Return the Sliced Stream
	 * 
	 */

	public static <T> Stream<T> getSliceOfStream3(Stream<T> stream, int startIndex, int endIndex) {
		return stream
				// Convert the stream to list
				.collect(Collectors.toList())

				// Fetch the subList between the specified index
				.subList(startIndex, endIndex + 1)

				// Convert the subList to stream
				.stream();
	}

	public static void main(String[] args) {

		// Create a new List with values 11 - 20
		List<Integer> list = new ArrayList<>();
		for (int i = 11; i <= 20; i++)
			list.add(i);

		// Create stream from list
		Stream<Integer> intStream = list.stream();

		// Print the stream
		System.out.println("List: " + list);

		// Get Slice of Stream
		// containing of elements from the 4th index to 8th
		Stream<Integer> sliceOfIntStream = getSliceOfStream(intStream, 4, 8);

		// Print the slice
		System.out.println("\nSlice of Stream:");
		sliceOfIntStream.forEach(System.out::println);

		// Create a new List with values 11 - 20
		List<Integer> list2 = new ArrayList<>();
		for (int i = 7; i <= 20; i++)
			list2.add(i);

		// Create stream from list
		Stream<Integer> intStream2 = list2.stream();

		// Print the stream
		System.out.println("List 2 : " + list2);

		// Get Slice of Stream
		// containing of elements from the 4th index to 8th
		Stream<Integer> sliceOfIntStream2 = getSliceOfStream(intStream2, 4, 8);

		// Print the slice
		System.out.println("\nSlice of Stream:");
		sliceOfIntStream2.forEach(System.out::println);
		
		// Create stream from list 
        Stream<Integer> intStream3 = list2.stream(); 
		
		 // Get Slice of Stream 
        // containing of elements from the 4th index to 8th 
        Stream<Integer> 
            sliceOfIntStream3 = getSliceOfStream(intStream3, 3, 10); 
  
        // Print the slice 
        System.out.println("\nSlice of Stream:"); 
        sliceOfIntStream3.forEach(System.out::println); 
	}
}
