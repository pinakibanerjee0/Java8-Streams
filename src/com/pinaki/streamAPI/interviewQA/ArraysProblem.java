package com.pinaki.streamAPI.interviewQA;

import java.util.Arrays;
import java.util.List;

public class ArraysProblem {

	public static void main(String[] args) {
		// get last element of an array
		getLastElementOfArray();
	}

	private static void getLastElementOfArray() {
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		String lastElement = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get();
		System.out.println(lastElement);
	}
}
