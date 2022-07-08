package me.wikmor.novum.person;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class Person extends LivingEntity {

	//private static Person john = new Person("John", 5);
	public static final Person JOHN = new Person("John", 5); // constant

	@Getter /*(AccessLevel.PRIVATE)*/
	private final int age; // if fields are final, then you must set their value in the constructor

	private static int ageStatic = 5;

	private Person() {
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

	protected final String privateMethod(String test, int demo) {
		System.out.println("Age of " + this.getName() + " is " + this.age);

		return "test=" + test + ", demo=" + demo;
	}

	protected void customMethod() {
	}

	@Override
	public void walk() {
		System.out.println("Walking 1km");
	}

	/*@Override
	public String toString() {
		return "Person{name=" + this.getName() + ", age=" + this.age + "}";
	}*/

	@Override
	public boolean equals(Object obj) {
		/*if (obj instanceof Person) {
			Person otherPerson = (Person) obj;

			if (otherPerson.getAge() == this.age && otherPerson.getName().equals(this.getName()))
				return true;
		}

		return false;*/

		return obj instanceof Person && ((Person) obj).getAge() == this.age && /*((Person) obj).getName().equals(this.getName())*/ super.equals(obj);
	}

	/*public static Person getJOHN() {
		return john;
	}*/
}
