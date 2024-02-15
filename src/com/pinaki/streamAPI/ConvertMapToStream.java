package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConvertMapToStream {
	/*
	 * 
	 * Converting complete Map<Key, Value> into Stream: This can be done with the
	 * help of Map.entrySet() method which returns a Set view of the mappings
	 * contained in this map. In Java 8, this returned set can be easily converted
	 * into a Stream of key-value pairs using Set.stream() method.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Map<Key, Value>. 2. Convert Map<Key, Value> into Set<Key> using
	 * Map.entrySet() method. 3. Convert the obtained Set into Stream using
	 * Set.stream() 4. Return/Print the Stream of Map.
	 */

	public static <K, V> Stream<Map.Entry<K, V>> convertMapToStream(Map<K, V> map) {

		// Return the obtained Stream
		return map

				// Convert the Map to Set
				.entrySet()

				// Convert the Set to Stream
				.stream();
	}

	/*
	 * 
	 * 2. Converting only the KeySet of the Map<Key, Value> into Stream: This can be
	 * done with the help of Map.keySet() method which returns a Set view of the
	 * keys contained in this map. In Java 8, this returned set can be easily
	 * converted into a Stream of key-value pairs using Set.stream() method.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Map<Key, Value>. 2. Convert Map<Key, Value> into Set<Key> using
	 * Map.keySet() method. 3. Convert the obtained Set into Stream using
	 * Set.stream() 4. Return/Print the Stream of Map.
	 */

	public static <K, V> Stream<K> convertKeySetOfMapToStream(Map<K, V> map) {

		// Return the obtained Stream
		return map

				// Convert the Map to Set<Key>
				.keySet()

				// Convert the Set to Stream
				.stream();
	}

	/*
	 * 
	 * Converting only the Value of the Map<Key, Value> into Stream: This can be
	 * done with the help of Map.values() method which returns a Set view of the
	 * values contained in this map. In Java 8, this returned set can be easily
	 * converted into a Stream of key-value pairs using Set.stream() method.
	 * 
	 * Algorithm:
	 * 
	 * 1. Get the Map<Key, Value>. 2. Convert Map<Key, Value> into Set<Value> using
	 * Map.values() method. 3. Convert the obtained Set into Stream using
	 * Set.stream() 4. Return/Print the Stream of Map.
	 */
	 public static <K, V> Stream<V> 
	    convertValuesOfMapToStream(Map<K, V> map) 
	    { 
	  
	        // Return the obtained Stream 
	        return map 
	  
	            // Convert the Map to Set<Value> 
	            .values() 
	  
	            // Convert the Set to Stream 
	            .stream(); 
	    } 
	public static void main(String args[]) {

		// Create a Map
		Map<Integer, String> map = new HashMap<>();

		// Add entries to the Map
		map.put(1, "Geeks");
		map.put(2, "forGeeks");
		map.put(3, "A computer Portal");

		// Print the Map
		System.out.println("Map: " + map);

		// Convert the Map to Stream
		Stream<Map.Entry<Integer, String>> stream = convertMapToStream(map);

		// Print the TreeMap
		System.out.println("Stream: " + Arrays.toString(stream.toArray()));

		// Convert the KeySet of Map to Stream
		Stream<Integer> stream2 = convertKeySetOfMapToStream(map);

		// Print the TreeMap
		System.out.println("Stream 2 : " + Arrays.toString(stream2.toArray()));
		
		  // Convert the Map to Stream 
        Stream<String> stream3 = convertValuesOfMapToStream(map); 
  
        // Print the TreeMap 
        System.out.println("Stream 3 : " 
                     + Arrays.toString(stream3.toArray())); 
	}
}
