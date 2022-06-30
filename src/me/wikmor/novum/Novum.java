package me.wikmor.novum;

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
	}
}
