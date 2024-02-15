package com.pinaki.streamAPI.interviewQA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Sorting {
	public static void main(String[] args) {
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

		// sort the given list of decimals in reverse order
		decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		int[] a = new int[] { 4, 2, 7, 2, 1 };
		int[] b = new int[] { 8, 3, 9, 5 };

		System.out.println("merge two unsorted arrays into single sorted array");
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::println);

		System.out.println("merge two unsorted arrays into single sorted array without duplicates");
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::println);

		System.out.println(" Given a list of strings, sort them according to increasing order of their length ");

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}
}
