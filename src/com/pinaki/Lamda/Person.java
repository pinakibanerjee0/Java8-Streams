package com.pinaki.Lamda;

import java.util.Random;

public class Person {

	private String name;
	private Integer age;

	// Constructor
	public Person() {
		Random ran = new Random();

		// Assigning a random value
		// to name
		this.name = ran.ints(97, 122 + 1).limit(7)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	// Constructor
	public Person(String name, int age) {
		// This keyword refers to current instance itself
		this.name = name;
		this.age = age;
	}

	// Getter-setters
	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

}
