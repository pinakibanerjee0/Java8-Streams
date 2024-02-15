package com.pinaki.streamAPI.interviewQA;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfEachCharacterInAString {
	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day";

		Map<Character, Long> charCountMap = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("FindFrequencyOfEachCharacterInAString " + inputString);
		System.out.println(charCountMap);

		// find frequency of each element
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");
		System.out.println("frequency of each element in List : \n" + stationeryList + " is : \n"
				+ findFrequencyOfEachItem(stationeryList));

	}

	private static String findFrequencyOfEachItem(List<String> stationeryList) {
		return stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.toString();
	}

}
