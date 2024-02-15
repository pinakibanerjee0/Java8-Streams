package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MathUsingStreams {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 5, 78, 69, 4, 6, 5 , 9, 3, 7, 72);

		System.out.println("Maximum Number is : " + getMax(list));
		System.out.println("Minimum Number is : " + getMin(list));
		System.out.println("Sum of Numbers : " + getSum(list));
		System.out.println("Average of Numbers : " + getAvg(list));
		System.out.println("Square of Numbers : " + getSquare(list));
		System.out.println("Numbers greater than the given no 7 are : " + getNumbersGreaterThan(list, 7));
		System.out.println("Numbers smaller than the given no 7 are : " + getNumbersSmallerThan(list, 7));
		System.out.println("Numbers starts than the given no 7 are : " + getNumbersStartsWith(list, "7"));
		System.out.println("First 4 numbers are : " + getFirstFour(list));
		System.out.println("Skip First 4 numbers from the list : " + skipFirstFour(list));
		System.out.println("Second Highest Number from the list : " + getSecondHighestNumber(list));
		System.out.println("Second Lowest Number from the list : " + getSecondLowestNumber(list));
		System.out.println("All the even Numbers are : " + getEvenNumbers(list));
		System.out.println("All the odd Numbers are : " + getOddNumbers(list));
		System.out.println("All the duplicates Numbers are : " + getDuplicteNumbers(list));
		System.out.println("Sorted Numbers in assending order are : " + getSortedNumbersAssending(list));
		System.out.println("Sorted Numbers in decending order are : " + getSortedNumbersDecending(list));




	}

	private static Integer getSecondLowestNumber(List<Integer> list) {
		return list.stream().sorted().distinct().skip(1).findFirst().get();
	}

	private static int getSecondHighestNumber(List<Integer> list) {
		return list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
	}

	private static List<Integer> skipFirstFour(List<Integer> list) {
		return list.stream().skip(4).collect(Collectors.toList());
	}

	private static List<Integer> getFirstFour(List<Integer> list) {
		return list.stream().limit(4).collect(Collectors.toList());
	}

	private static List<Integer> getSortedNumbersDecending(List<Integer> list) {
		return list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

	private static List<Integer> getSortedNumbersAssending(List<Integer> list) {
		return list.stream().sorted().collect(Collectors.toList());
	}

	private static int getMin(List<Integer> list) {
		return list.stream().min(Comparator.comparing(Integer::valueOf)).get();
	}

	private static int getMax(List<Integer> list) {
		return list.stream().max(Comparator.comparing(Integer::valueOf)).get();
	}

	private static int getSum(List<Integer> list) {
		return list.stream().reduce((a, b) -> (a + b)).get();
	}

	private static double getAvg(List<Integer> list) {

		return list.stream().mapToInt(e -> e).average().getAsDouble();
	}
	private static Set<Integer> getDuplicteNumbers(List<Integer> list) {
		// Approach 1 :
		  
		/* 
		 * return list.stream()
				.filter(e->Collections.frequency(list, e)>1) // elements frequency is greater than 1
				.collect(Collectors.toSet());
				
		*/
		
		//Approach 2 :
		HashSet<Integer> hashSet = new HashSet<>();
		return list.stream().filter(e->!hashSet.add(e)).collect(Collectors.toSet());
	}

	private static List<Integer> getNumbersStartsWith(List<Integer> list, String i) {
		return list.stream()
				.map(String::valueOf) //convert each elements to String
				.filter(e -> e.startsWith(i)) // filter out the elements which starts with the given number
				.map(Integer::valueOf) // convert elements to Integer
				.collect(Collectors.toList());
	}

	private static List<Integer> getOddNumbers(List<Integer> list) {
		return list.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
	}

	private static List<Integer> getEvenNumbers(List<Integer> list) {
		return list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
	}

	private static List<Integer> getNumbersSmallerThan(List<Integer> list, int i) {
		return list.stream().filter(e -> e < i).collect(Collectors.toList());
	}

	private static List<Integer> getNumbersGreaterThan(List<Integer> list, int i) {
		return list.stream().filter(e -> e > i).collect(Collectors.toList());
	}

	private static List<Integer> getSquare(List<Integer> list) {
		return list.stream().map(e -> e * e).collect(Collectors.toList());
	}
}
