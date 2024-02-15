package com.pinaki.Lamda;

public class CheckStringContainsOnlyAlphabets {
	/*
	 * 
	 * Algorithm: Get the string Match the string: Check if the string is null or
	 * not. If null, return false. Check if the string is empty or not. If empty,
	 * return false If the string is neither empty nor null, then check using Lambda
	 * Expression Character::isLetter(). Return true if matched
	 */

	// To check String for only Alphabets
	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.chars().allMatch(Character::isLetter)));
	}

	public static void main(String[] args) {
		// Display message
		System.out.println("Test Case 1:");

		String str1 = "GeeksforGeeks";
		System.out.println("Input: " + str1);

		// Calling over above string: GeeksforGeeks
		System.out.println("Output: " + isStringOnlyAlphabet(str1));
	}

}
