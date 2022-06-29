package me.wikmor.novum;

public class Employee extends Person implements Nice, Rich {

	String position;
	double salary;

	Employee(String position, double salary) {
		this.position = position;
		this.salary = salary;
	}

	@Override
	void walk() {
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

	@Override
	public void eat() {

	}

	String getPosition() {
		return position;
	}

	double getSalary() {
		return salary;
	}

	void setPosition(String position) {
		this.position = position;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}
}
