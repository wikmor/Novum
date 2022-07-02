package me.wikmor.novum;

import me.wikmor.novum.house.House;
import me.wikmor.novum.person.Employee;
import me.wikmor.novum.person.EntityRegister;
import me.wikmor.novum.person.Person;
import me.wikmor.novum.person.attributes.Nice;
import me.wikmor.novum.water.BottleRegister;
import me.wikmor.novum.water.WaterBottle;

public class Novum {

	public static void main(String[] args) {
		Person person = new Person();
		System.out.println("person = " + person.getName() + ", age: " + person.getAge());

		Person anonymous = new Person(2);
		System.out.println("anonymous = " + anonymous.getName() + ", age: " + anonymous.getAge());

		Person elvis = new Person("Elvis", 1);
		System.out.println("elvis = " + elvis.getName() + ", age: " + elvis.getAge());

		Employee employee = new Employee("CEO", 500_000);
		employee.setName("Milena");
		System.out.println("employee = " + employee.getName() + ", age: " + employee.getAge() + ", position: " + employee.getPosition() + ", salary: " + employee.getSalary());
		employee.walk();
		employee.eat();

		Object myPerson = new Employee("CEO", 500_000);

		if (myPerson instanceof Employee) {
			System.out.println(((Employee) myPerson).getAge());
		}

		if (myPerson instanceof Nice) {
			Nice nicePerson = (Nice) myPerson;

			nicePerson.eat();
		}

		// Cannot access because customMethod() is set to protected in Person class, which is in the different package and Novum isn't a child of Person
		// ((Person) myPerson).customMethod();

		Person newPerson1 = new Person("John", 900);
		Person newPerson2 = new Person("John", 900);

		// byte, short, int, long, double, float, char, boolean
		// for primitives, use ==

		// for objects, use equals, for objects other than strings you need to write you own custom equals method
		if (newPerson1.equals(newPerson2))
			System.out.println("person1 = person2");

		House one = new House(250);
		new House(2500);
		new House(550);

		// More advanced way, static fields and methods with non-static ones.
		System.out.println("Registered houses: " + House.getRegisteredHouses());

		System.out.println(Person.JOHN.getName());

		// Beginner way, using dedicated class with only static fields and methods.
		System.out.println("Registered entities: " + EntityRegister.getRegisteredEntities());
	}
}
