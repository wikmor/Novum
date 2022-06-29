package me.wikmor.novum;

public class Person extends LivingEntity {

	final int age; // if fields are final, then you must set their value in the constructor

	Person() {
		super(null);

		this.age = 0;
	}

	Person(int age) {
		this("Anonymous", age);
	}

	Person(String name, int age) {
		super(name);

		this.name = name;
		this.age = age;
	}

	@Override
	void walk() {
		System.out.println("Walking 1km");
	}

	@Override
	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	@Override
	void setName(String name) {
		this.name = name;
	}
}
