package com.pinaki.Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MethodReference_Constructor {

	// Get List of objects of given
	// length and Supplier
	public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply) {
		List<T> list = new ArrayList<>();

		for (int i = 0; i < length; i++)
			list.add(objectSupply.get());
		return list;
	}

	public static void main(String[] args) {

		// Get 10 person by supplying
		// person supplier, Supplier is
		// created by person constructor
		// reference
		List<Person> personList = getObjectList(5, Person::new);

		// Print names of personList
		personList.stream().map(x -> x.getName()).forEach(System.out::println);
	}
}
