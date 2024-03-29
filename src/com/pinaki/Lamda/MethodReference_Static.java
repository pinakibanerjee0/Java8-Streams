package com.pinaki.Lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MethodReference_Static {
	// Method 1
	// Static method to compare with name
	public static int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

	// Method 2
	// Static method to compare with age
	public static int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}

	// Method 3
	// Main driver method
	public static void main(String[] args) {

		// Creating an empty ArrayList of user-defined type
		// List of person
		List<Person> personList = new ArrayList<>();

		// Adding elements to above List
		// using add() method
		personList.add(new Person("vicky", 24));
		personList.add(new Person("poonam", 25));
		personList.add(new Person("sachin", 19));

		// Using static method reference to
		// sort array by name
		Collections.sort(personList, MethodReference_Static::compareByName);

		// Display message only
		System.out.println("Sort by name :");

		// Using streams over above object of Person type
		personList.stream().map(x -> x.getName()).forEach(System.out::println);

		// Now using static method reference
		// to sort array by age
		Collections.sort(personList, MethodReference_Static::compareByAge);

		// Display message only
		System.out.println("Sort by age :");

		// Using streams over above object of Person type
		personList.stream().map(x -> x.getName()).forEach(System.out::println);
	}

}