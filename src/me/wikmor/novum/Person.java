package me.wikmor.novum;

public class Person {

	String name;
	int age;

	Person() {
	}

	Person(int age) {
		this("Anonymous", age);
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	void setName(String name) {
		this.name = name;
	}

	void setAge(int age) {
		this.age = age;
	}
}
