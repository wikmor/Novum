package me.wikmor.novum.person;

public class Person extends LivingEntity {

	private final int age; // if fields are final, then you must set their value in the constructor

	public Person() {
		super(null);

		this.age = 0;
	}

	public Person(int age) {
		this("Anonymous", age);
	}

	public Person(String name, int age) {
		super(name);

		this.age = age;
	}

	protected void customMethod() {
	}

	@Override
	public void walk() {
		System.out.println("Walking 1km");
	}

	public int getAge() {
		return age;
	}
}
