package com.pinaki.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertStreamToMap {
	/*
	 * 
	 * Method 1: Using Collectors.toMap() Function
	 * 
	 * The Collectors.toMap() method takes two parameters as the input:
	 * 
	 * 1. KeyMapper: This function is used for extracting keys of the Map from
	 * stream value. 2. ValueMapper: This function used for extracting the values of
	 * the map for the given key.
	 */
	public static Map toMap(String input) {
		Map<String, Integer> lengthMap = Arrays.stream(input.split(" "))
				.collect(Collectors.toMap(value -> value, value -> value.length()));

		return lengthMap;
	}

	/*
	 * 
	 * Example 2: Now, lets use the toMap function to perform a bit more complex map
	 * conversion. Here, we will convert a list of users into a map where UserId is
	 * the key and the User is the value.
	 */

	// Function to convert the User
	// to the map
	public static Map toMap(User user1, User user2, User user3) {

		Map<Integer, User> userMap = Arrays.asList(user1, user2, user3).stream()
				.collect(Collectors.toMap(u -> u.getUserId(), u -> u));

		return userMap;
	}

	/*
	 * Method 3: Using Collectors
	 * 
	 * The groupingBy collector takes one function as input and creates a group of
	 * stream objects using that function. The following are the examples to convert
	 * a stream into a map using groupingBy collector.
	 * 
	 * 
	 */

	public static Map toMap(User user1, User user2, User user3, User user4, User user5) {
		Map<String, List<User>> cityUserListMap = Arrays.asList(user1, user2, user3, user4, user5).stream()
				.collect(Collectors.groupingBy(User::getCity));

		return cityUserListMap;
	}

	/*
	 * 
	 * We can also provide an additional collector to the groupingBy if we need some
	 * extra information than the actual object. In this example, we will see how to
	 * get the count of the users belonging to each city.
	 */

	public static Map toMapCount(User user1, User user2, User user3, User user4, User user5) {

		Map<String, Long> cityUserCountMap = Arrays.asList(user1, user2, user3, user4, user5).stream()
				.collect(Collectors.groupingBy(User::getCity, Collectors.counting()));

		return cityUserCountMap;
	}

	public static void main(String[] args) {
		String input = "Hi, My Name is Pinaki";

		System.out.println(toMap(input));

		// Creating users
		User user1 = new User(1, "User1", "Pune");

		User user2 = new User(2, "User2", "Mumbai");

		User user3 = new User(3, "User3", "Nagpur");

		System.out.println(toMap(user1, user2, user3));

		User user4 = new User(4, "User4", "Pune");
		User user5 = new User(5, "User5", "Mumbai");
		System.out.println(toMap(user1, user2, user3, user4, user5));
		System.out.println(toMapCount(user1, user2, user3, user4, user5));

	}

	// Implementing the User class
	public static class User {

		// Attributes of the user class
		private int userId;
		private String name;
		private String city;

		// Constructor
		public User(int userId, String name, String city) {
			this.userId = userId;
			this.name = name;
			this.city = city;
		}

		// Getters of the user class
		public int getUserId() {
			return userId;
		}

		public String getName() {
			return name;
		}

		public String getCity() {
			return city;
		}

		// Overriding the toString method
		// to return the custom string
		@Override
		public String toString() {
			return "User [userId = " + userId + ", name = " + name + ", city = " + city + "]";
		}
	}
}
