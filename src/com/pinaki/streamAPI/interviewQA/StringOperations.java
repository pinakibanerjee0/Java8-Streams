package com.pinaki.streamAPI.interviewQA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringOperations {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
		// join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter
		System.out.println(listOfStrings.stream().collect(Collectors.joining(", ", "[", "]")));

		// check if two strings are anagrams or not
		isAnagram();
		// Reverse each word of a string
		reverseWords();
		// Palindrome program using Java 8 streams
		isPalindrome();
		// find out those strings which start with a number
		stringsStartsWithNumers();
		// find Duplicate Elements in an Array
		findDuplicateInAnArray();
		// Print duplicate characters in a string
		printDuplicatesInString();
		// first repeated character in a string
		findFirstRepeatedCharacterInString();
		// first non-repeated character in s String
		findFirstNonRepeatedCharacterInString();
	}

	private static void findFirstNonRepeatedCharacterInString() {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

		Map<String, Long> charCountMap = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String firstNonRepeatedChar = charCountMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
				.map(entry -> entry.getKey()).findFirst().get();

		System.out.println(firstNonRepeatedChar);
	}

	private static void findFirstRepeatedCharacterInString() {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

		Map<String, Long> charCountMap = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String firstRepeatedChar = charCountMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).findFirst().get();

		System.out.println(firstRepeatedChar);

	}

	private static void printDuplicatesInString() {

		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		Set<String> uniqueChars = new HashSet<>();
		Set<String> duplicateChars = Arrays.stream(inputString.split("")).filter(ch -> !uniqueChars.add(ch))
				.collect(Collectors.toSet());

		System.out.println(duplicateChars);
	}

	private static void findDuplicateInAnArray() {
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		Set<Integer> uniqueElements = new HashSet<>();
		Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> !uniqueElements.add(i))
				.collect(Collectors.toSet());
		System.out.println(duplicateElements);
	}

	private static void stringsStartsWithNumers() {
		List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
	}

	private static void isPalindrome() {
		String str = "ROTATOR";

		boolean isItPalindrome = IntStream.range(0, str.length() / 2)
				.noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));

		if (isItPalindrome) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not a palindrome");
		}
	}

	private static void reverseWords() {
		String str = "Java Concept Of The Day";

		String reversedStr = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(reversedStr);
	}

	private static void isAnagram() {
		String s1 = "RaceCar";
		String s2 = "CarRace";

		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		if (s1.equals(s2)) {
			System.out.println("Two strings are anagrams");
		} else {
			System.out.println("Two strings are not anagrams");
		}
	}
}
