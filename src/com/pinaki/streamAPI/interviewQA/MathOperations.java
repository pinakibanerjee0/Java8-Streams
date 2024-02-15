package com.pinaki.streamAPI.interviewQA;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathOperations {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		// print the numbers which are multiples of 5
		listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);

		// find maximum and minimum of those numbers
		int max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Maximum Element : " + max);

		int min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		System.out.println("Minimum Element : " + min);

		// get three maximum numbers and three minimum numbers from the given list

		// 3 minimum Numbers

		System.out.println("-----------------");
		System.out.println("Minimum 3 Numbers");

		listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);

		// 3 Maximum Numbers

		System.out.println("-----------------");
		System.out.println("Maximum 3 Numbers");

		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

		// sum of all digits of a number

		int i = 15623;
		System.out.println("sum of all digits of a number " + i + " is \n"
				+ Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt)).toString());

		System.out.println("second largest number in an integer array  : "
				+ listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

		System.out.println("Given an integer array, find sum and average of all elements ");
		int[] a = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };
		int sum = Arrays.stream(a).sum();
		System.out.println("Sum = " + sum);
		double average = Arrays.stream(a).average().getAsDouble();
		System.out.println("Average = " + average);

		System.out.println("find common elements between two arrays : ");
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
		List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
		list1.stream().filter(list2::contains).forEach(System.out::println);

		String str = "Java Concept Of The Day";
		System.out.println("Reverse each word of the string " + str);
		String reversedStr = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(reversedStr);
		
		// find First 10 natural , odd , even , fibonacci Numbers
		findFirst10Numbers();

		System.out.println("find sum of first 10 natural numbers " + IntStream.range(1, 11).sum());
		System.out.println("Reverse an integer array ");
		int[] array = new int[] { 5, 1, 7, 3, 9, 6 };
		int[] reversedArray = IntStream.rangeClosed(1, array.length).map(l -> array[array.length - l]).toArray();
		System.out.println(Arrays.toString(reversedArray));

		

		System.out.println("find the most repeated element in an array");

		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil");
		Map<String, Long> elementCountMap = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Entry<String, Long> mostFrequentElement = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
				.get();
		System.out.println("Most Frequent Element : " + mostFrequentElement.getKey());
		System.out.println("Count : " + mostFrequentElement.getValue());
		
		// Find the age of a person in years if the birthday has given
		calculateAge();

	}

	private static void findFirst10Numbers() {
		System.out.println("Print first 10 even numbers");
		IntStream.rangeClosed(1, 10).map(p -> p * 2).forEach(System.out::println);
		
		System.out.println("\nFirst 10 odd numbers ....");
		Stream.iterate(new int[] { 1, 3 }, f -> new int[] { f[1], f[1] + 2 }).limit(10).map(f -> f[0])
				.forEach(System.out::println);
		
		System.out.println("\nFirst 10 Fibonacci series ....");
		Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10).map(f -> f[0])
				.forEach(System.out::println);				

		System.out.println("\nfind first 10 natural numbers ");
		IntStream.range(1, 11).forEach(System.out::println);
		
		System.out.println("\nfind sum of first 10 natural numbers " + IntStream.range(1, 11).sum());
	}

	private static void calculateAge() {
		LocalDate birthDay = LocalDate.of(1985, 01, 23);
		LocalDate today = LocalDate.now();

		System.out.println("\nAge is : "+ChronoUnit.YEARS.between(birthDay, today));
	}
}
