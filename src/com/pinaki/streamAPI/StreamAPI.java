package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {

		// List<Integer> myList = ;
		usefulOperationUsingStreamAPI(Arrays.asList(10, 19, 25, 8, 49, 25, 97, 97, 32));

		stringsOperationUsingStream("My Name is Pinaki Banerjee");
		
		sortingUsingStram(Arrays.asList(10,15,8,49,25,98,98,32,15));
	}

	private static void sortingUsingStram(List<Integer> list) {

		System.out.println("**** sort all the values present in the list ****");
		list.stream() .sorted() .forEach(System.out::println);
		
		System.out.println("** sort all the values present in it in descending order **");
		list.stream() .sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

	private static void stringsOperationUsingStream(String input) {
		System.out.println("the first non-repeated character is : ");
		Character result = input.chars() // Stream of String
				// First convert to Character object and then to lower case
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				// Store the chars in map with count
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);

		System.out.println("first repeated character is : ");

		result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				// First convert to Character object and then to lower case
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				// Store the chars in map with count
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);
	}

	private static void usefulOperationUsingStreamAPI(List<Integer> myList) {

		System.out.println("Length of the list is : " + myList.stream().count());

		System.out.println("The First Element Of The List is : ");
		myList.stream().findFirst().ifPresent(System.out::println);

		System.out.println("Maimum Value in the List is : ");
		System.out.println(myList.stream().max(Integer::compare).get());

		System.out.println("Duplicate Elements in the List are :");
		Set<Integer> set = new HashSet();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		System.out.println("All the even numbers exist in the list");
		myList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("All the numbers starting with 1 are : ");
		myList.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(System.out::println);
	}

}
