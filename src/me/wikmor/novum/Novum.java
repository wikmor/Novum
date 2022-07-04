package me.wikmor.novum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import me.wikmor.novum.house.House;
import me.wikmor.novum.person.Employee;
import me.wikmor.novum.person.EntityRegister;
import me.wikmor.novum.person.Person;
import me.wikmor.novum.person.attributes.Nice;
import me.wikmor.novum.water.BottleRegister;
import me.wikmor.novum.water.WaterBottle;

public class Novum {

	private static final int LEFT_HAND_NUMBER = 0;
	private static final int RIGHT_HAND_NUMBER = 1;
	private static final int OPERATOR = 2;

	public static void main(String[] args) {
		Novum novum = new Novum();

		try {
			//novum.loop();

		} catch (Throwable t) {
			System.out.println("Oops, an error occured: " + t.getMessage());

			t.printStackTrace();
		}

		//novum.testConstructors();
		//novum.testInheritanceAndPolymorphism();
		//novum.testCastingAndInstanceof();
		//novum.testAccessModifiers();
		//novum.testEquals();
		//novum.testStatic();
		//novum.testList();
		//novum.testSet();
		//novum.testQueue();
		novum.testMap();

	}

	private void loop() {

		Scanner scanner = new Scanner(System.in);
		String message = "";

		int mode = LEFT_HAND_NUMBER;
		double[] numbers = new double[2];

		while (!message.equals("exit")) {

			if (mode > OPERATOR)
				mode = 0;

			if (mode == LEFT_HAND_NUMBER)
				System.out.println("Please type the first number.");

			else if (mode == RIGHT_HAND_NUMBER)
				System.out.println("Please type the second number.");

			else
				System.out.println("Please type the operator: + - / * %");

			message = scanner.nextLine();

			try {
				if (mode == LEFT_HAND_NUMBER)
					numbers[0] = Double.parseDouble(message);

				else if (mode == RIGHT_HAND_NUMBER)
					numbers[1] = Double.parseDouble(message);

				else {
					double result = 0;

					if ("+".equals(message))
						result = sum(numbers[0], numbers[1]);

					else if ("-".equals(message))
						result = subtract(numbers[0], numbers[1]);

					else if ("/".equals(message))
						result = divide(numbers[0], numbers[1]);

					else if ("*".equals(message))
						result = multiply(numbers[0], numbers[1]);

					else if ("%".equals(message))
						result = modulo(numbers[0], numbers[1]);

					else {
						System.out.println("Invalid operator: " + message);

						continue;
					}

					System.out.println(numbers[0] + " " + message + " " + numbers[1] + " = " + result);
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid number: " + message);

				continue;
			}

			mode++;
		}

		System.out.println("The program has quit. Good luck!");
		scanner.close();
	}

	private double sum(double leftHandNumber, double rightHandNumber) {
		return leftHandNumber + rightHandNumber;
	}

	private double subtract(double leftHandNumber, double rightHandNumber) {
		return leftHandNumber - rightHandNumber;
	}

	private double divide(double leftHandNumber, double rightHandNumber) {
		return leftHandNumber / rightHandNumber;
	}

	private double multiply(double leftHandNumber, double rightHandNumber) {
		return leftHandNumber * rightHandNumber;
	}

	private double modulo(double leftHandNumber, double rightHandNumber) {
		return leftHandNumber % rightHandNumber;
	}

	private void testConstructors() {
		Person person = new Person();
		System.out.println("person = " + person.getName() + ", age: " + person.getAge());

		Person anonymous = new Person(2);
		System.out.println("anonymous = " + anonymous.getName() + ", age: " + anonymous.getAge());

		Person elvis = new Person("Elvis", 1);
		System.out.println("elvis = " + elvis.getName() + ", age: " + elvis.getAge());
	}

	private void testInheritanceAndPolymorphism() {
		Employee employee = new Employee("CEO", 500_000);
		employee.setName("Milena");
		System.out.println("employee = " + employee.getName() + ", age: " + employee.getAge() + ", position: " + employee.getPosition() + ", salary: " + employee.getSalary());
		employee.walk();
		employee.eat();
	}

	private void testCastingAndInstanceof() {
		Object myPerson = new Employee("CEO", 500_000);

		if (myPerson instanceof Employee) {
			System.out.println(((Employee) myPerson).getAge());
		}

		if (myPerson instanceof Nice) {
			Nice nicePerson = (Nice) myPerson;

			nicePerson.eat();
		}
	}

	private void testAccessModifiers() {
		// Cannot access because customMethod() is set to protected in Person class, which is in the different package and Novum isn't a child of Person
		// ((Person) myPerson).customMethod();
	}

	private void testEquals() {
		Person newPerson1 = new Person("John", 900);
		Person newPerson2 = new Person("John", 900);

		// byte, short, int, long, double, float, char, boolean
		// for primitives, use ==

		// for objects, use equals, for objects other than strings you need to write you own custom equals method
		if (newPerson1.equals(newPerson2))
			System.out.println("person1 = person2");
	}

	private void testStatic() {
		House one = new House(250);
		new House(2500);
		new House(550);

		// More advanced way, static fields and methods with non-static ones.
		System.out.println("Registered houses: " + House.getRegisteredHouses());

		System.out.println(Person.JOHN.getName());

		// Beginner way, using dedicated class with only static fields and methods.
		System.out.println("Registered entities: " + EntityRegister.getRegisteredEntities());

		WaterBottle polaris = new WaterBottle();
		WaterBottle cisowianka = new WaterBottle("Cisowianka");
		WaterBottle zywiec = new WaterBottle("Żywiec Zdrój", 0.5);
		WaterBottle wojcieszowianka = new WaterBottle("Wojcieszowianka", 0.5, true);

		System.out.println("\nMake: " + polaris.getName() + ", capacity: " + polaris.getCapacity() + ", is sparkling? " + polaris.isSparkling());
		System.out.println("Make: " + cisowianka.getName() + ", capacity: " + cisowianka.getCapacity() + ", is sparkling? " + cisowianka.isSparkling());
		System.out.println("Make: " + zywiec.getName() + ", capacity: " + zywiec.getCapacity() + ", is sparkling? " + zywiec.isSparkling());
		System.out.println("Make: " + wojcieszowianka.getName() + ", capacity: " + wojcieszowianka.getCapacity() + ", is sparkling? " + wojcieszowianka.isSparkling());

		// TODO How to print details of all water bottles using a loop?
		//for (WaterBottle bottle : BottleRegister.getRegisteredBottles())
		//	System.out.println("Make: " + );

		System.out.println("Registered water bottles: " + BottleRegister.getRegisteredBottles());
	}

	private void testList() {
		// int[] numbers = { 1, 5, 100 }; // Lack convenience methods such as .add()

		List<Integer> numbersList = new ArrayList<>();
		numbersList.add(1);
		numbersList.add(5);
		numbersList.add(100);

		//numbersList.get(3); // Index 3 out of bounds for length 3

		List<Integer> numbers = new ArrayList<>();

		numbers.add(1);
		numbers.add(10);
		numbers.add(1);

		for (int /* can be not Integer, because of Java auto-boxing */ number : numbers)
			System.out.println(number);

		for (int index = 0; index < numbers.size(); index++)
			System.out.println(numbers.get(index));

		System.out.println("Numbers before: " + numbers);

		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			int number = iterator.next();

			if (number < 5) {
				iterator.remove();

				continue;
			}

			System.out.println(number);
		}

		System.out.println("Numbers after: " + numbers);
	}

	private void testSet() {
		Set<Integer> numbers = new HashSet<>();

		numbers.add(1);
		numbers.add(10);
		numbers.add(15550);
		numbers.add(2);

		System.out.println("Numbers: " + numbers);
	}

	private void testQueue() {
		Queue<Integer> numbers = new ArrayBlockingQueue<>(3);

		numbers.add(1);
		numbers.add(10);
		numbers.add(15550);

		numbers.poll();

		numbers.add(2);

		System.out.println("Numbers: " + numbers);
	}

	private void testMap() {
		Map<String, Integer> map = new HashMap<>();

		map.put("hello", 500);
		map.put("hello2", 200);
		map.put("hello2", 5000);

		map.remove("hello");

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String word = entry.getKey();
			int number = entry.getValue();

			System.out.println(word + ": " + number);
		}

		System.out.println("Map: " + map);
	}
}
