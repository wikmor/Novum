package me.wikmor.novum.person;

import me.wikmor.novum.Position;
import me.wikmor.novum.person.attributes.Nice;
import me.wikmor.novum.person.attributes.Rich;

public class Employee extends Person implements Nice, Rich {

	private Position position;
	private double salary;

	public Employee(String name, int age, Position position, double salary) {
		super(name, age);

		this.position = position;
		this.salary = salary;
	}

	void takeNumber(byte veryTinyNumber) {
		System.out.println(veryTinyNumber);

		this.customMethod(); // can access protected since it's a child class of Person
	}

	@Override
	public void walk() {
		System.out.println("Run 2km");
	}

	@Override
	public void smile(int intensity) {
		// put up a fake-ass smile
	}

	@Override
	public void dropDiamonds() {
		// drop a stack of diamonds
	}

	@Override
	public String brag() {
		return "Hey look at me!";
	}

	public Position getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{name=" + this.getName() + ", age=" + this.getAge() + ", position=" + this.position + ", salary=" + this.salary + "}";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Employee && ((Employee) obj).getPosition().equals(this.position) && ((Employee) obj).getSalary() == this.salary && super.equals(obj);
	}
}
