package me.wikmor.novum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import lombok.NonNull;
import me.wikmor.novum.house.House;
import me.wikmor.novum.person.Employee;
import me.wikmor.novum.person.EntityRegister;
import me.wikmor.novum.person.Person;
import me.wikmor.novum.person.attributes.Nice;
import me.wikmor.novum.water.BottleRegister;
import me.wikmor.novum.water.WaterBottle;

public class Novum {

	private static final Object LOCK = new Object();

	static int decreaseMe = 10; // ConcurrentHashMap for maps = no need to use synchronized keyword

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
		//novum.testMap();
		//novum.testHashCode();
		//novum.testTree();
		//novum.testToString();
		//novum.testRandom();
		//novum.testEnumeration();
		//novum.testSwitch();
		//novum.testMultiDimensions();
		//novum.testAnonymousAndInnerClasses();
		//novum.testStaticConstructorAndInitializers();
		//novum.testLambda();
		//novum.testReflection();
		//novum.testThreads();
		//novum.testSynchronized();
		//novum.testTimer();
		novum.testLombok();

		/*int number = 10;

		resursivePrint(number);*/
	}

	private void loop() {
		Scanner scanner = new Scanner(System.in);
		String message = "";

		int mode = CalculatorMode.LEFT_HAND_NUMBER.getNumber();
		double[] numbers = new double[2];

		while (!message.equals("exit")) {

			if (mode > CalculatorMode.OPERATOR.getNumber())
				mode = 0;

			if (mode == CalculatorMode.LEFT_HAND_NUMBER.getNumber())
				System.out.println("Please type the first number.");

			else if (mode == CalculatorMode.RIGHT_HAND_NUMBER.getNumber())
				System.out.println("Please type the second number.");

			else
				System.out.println("Please type the operator: + - / * %");

			message = scanner.nextLine();

			try {
				if (mode == CalculatorMode.LEFT_HAND_NUMBER.getNumber())
					numbers[0] = Double.parseDouble(message);

				else if (mode == CalculatorMode.RIGHT_HAND_NUMBER.getNumber())
					numbers[1] = Double.parseDouble(message);

				else {
					double result = 0;

					switch (message) {
						case "+" -> result = sum(numbers[0], numbers[1]);
						case "-" -> result = subtract(numbers[0], numbers[1]);
						case "/" -> result = divide(numbers[0], numbers[1]);
						case "*" -> result = multiply(numbers[0], numbers[1]);
						case "%" -> result = modulo(numbers[0], numbers[1]);
						default -> {
							System.out.println("Invalid operator: " + message);

							continue;
						}
					}

					/*if ("+".equals(message))
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
					}*/

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
		//Person person = new Person();
		//System.out.println("person = " + person.getName() + ", age: " + person.getAge());

		Person anonymous = new Person(2);
		System.out.println("anonymous = " + anonymous.getName() + ", age: " + anonymous.getAge());

		Person elvis = new Person("Elvis", 1);
		System.out.println("elvis = " + elvis.getName() + ", age: " + elvis.getAge());
	}

	private void testInheritanceAndPolymorphism() {
		Employee employee = new Employee("Wiktor", 20, Position.CEO, 500_000);
		employee.setName("Milena");
		System.out.println("employee = " + employee.getName() + ", age: " + employee.getAge() + ", position: " + employee.getPosition() + ", salary: " + employee.getSalary());
		employee.walk();
		employee.eat();
	}

	private void testCastingAndInstanceof() {
		Object myPerson = new Employee("Milena", 20, Position.COO, 500_000);

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
		WaterBottle zywiec = new WaterBottle("??ywiec Zdr??j", 0.5);
		WaterBottle wojcieszowianka = new WaterBottle("Wojcieszowianka", 0.5, true);

		/*System.out.println("\nMake: " + polaris.getName() + ", capacity: " + polaris.getCapacity() + ", is sparkling? " + polaris.isSparkling());
		System.out.println("Make: " + cisowianka.getName() + ", capacity: " + cisowianka.getCapacity() + ", is sparkling? " + cisowianka.isSparkling());
		System.out.println("Make: " + zywiec.getName() + ", capacity: " + zywiec.getCapacity() + ", is sparkling? " + zywiec.isSparkling());
		System.out.println("Make: " + wojcieszowianka.getName() + ", capacity: " + wojcieszowianka.getCapacity() + ", is sparkling? " + wojcieszowianka.isSparkling());*/

		// TODO Ask if I did it right (shouldn't it be in BottleRegister class?)
		for (WaterBottle bottle : BottleRegister.getWaterBottles().values())
			System.out.println(bottle);

		System.out.println("Registered water bottles: " + BottleRegister.getRegisteredBottles());

		System.out.println("Water bottle by id: " + BottleRegister.getWaterBottleById(1));
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

	private void testHashCode() {
		Map<UniquePerson, Integer> map = new HashMap<>();

		map.put(new UniquePerson("hello"), 1);
		map.put(new UniquePerson("hello"), 1);

		System.out.println("Map: " + map);
	}

	private void testTree() {
		Set<String> names = new TreeSet<>((first, second) -> second.compareTo(first));

		names.add("Xatej");
		names.add("Alex");
		names.add("Bob");

		System.out.println(names);

		names.add("Nataly");

		System.out.println(names);

		Map<Integer, String> scores = new TreeMap<>((first, second) -> Integer.compare(second, first));

		scores.put(5, "Matej");
		scores.put(99, "Lisa");
		scores.put(152353, "John");
		scores.put(100, "Nataly");

		System.out.println(scores);
	}

	private void testToString() {
		House house = new House(140);
		House house2 = new House(1400);

		System.out.println("This house is: " + house);
		System.out.println("This house is: " + house2);

		Employee employee = new Employee("John", 29, Position.DOUCHE, 1_000_000);

		System.out.println("Employee of the month: " + employee);
	}

	private void testRandom() {
		String[] letters = { "a", "b", "c", "d", "e", "f", "p" };
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			//double randomNumber = random.nextDouble();

			System.out.println(letters[random.nextInt(letters.length)]);
		}
	}

	private void testEnumeration() {
		Employee employee = new Employee("Wiktor", 20, Position.CEO, 1000000);
		System.out.println(employee);
		Position.CEO.giveToPlayer("none");
		Position.DOUCHE.giveToPlayer("none");
	}

	private void testSwitch() {
		String weekDay = "Tuesday";

		switch (weekDay) {
			case "Monday":
				System.out.println("It's Monday!");
				break;

			case "Tuesday":
				System.out.println("It's Tuesday!");
				break;

			case "Wednesday":
			case "Thursday":
			case "Friday":
			case "Saturday":
			case "Sunday":
				System.out.println("It's the rest of the week!");

			default:
				System.out.println("Unknown week!");
				throw new RuntimeException("Unknown exception: " + weekDay);
		}

		// Java 17+
		switch (weekDay) {
			case "Monday" -> System.out.println("It's Monday!");
			case "Tuesday" -> System.out.println("It's Tuesday!");
			default -> System.out.println("It's another day!");
		}

		System.out.println("End of the program");
	}

	private void testMultiDimensions() {
		int[][] numbers = { { 1, 1 }, { 2, 2 }, { 3, 0 }, { 4, 55 }, { 5, -10 } };

		for (int[] secondDimension : numbers)
			for (int number : secondDimension)
				System.out.println("Number: " + number);

		Material[][][] chunkSectionMaterials = new Material[16][16][16];

		chunkSectionMaterials[0][1][0] = Material.DIAMOND_BLOCK;

		System.out.println(chunkSectionMaterials[0][0][0]);
		System.out.println(chunkSectionMaterials[0][1][0]);
	}

	private void testAnonymousAndInnerClasses() {
		Nice nice = new Nice() {

			@Override
			public void smile(int intensity) {
				// TODO Auto-generated method stub

			}

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				Nice.super.eat();
			}

		};

		Object[] objects = new Object[] { 1, Position.CEO };

		join(objects, object -> {

			if (object instanceof Integer) {
				return ((Integer) object).toString();
			}

			if (object instanceof Position) {
				return ((Position) object).name();
			}

			return object.toString();
		});
	}

	static String join(Object[] objects, Joiner joiner) {
		List<String> convertedWords = new ArrayList<>();

		for (Object object : objects)
			convertedWords.add(joiner.convertToString(object));

		return String.join(", ", convertedWords);
	}

	public interface Joiner {

		String convertToString(Object object);
	}

	public void methodHere() {

	}

	public /*static*/ class Demo {

		Demo() {
			this.methodHere();
			Novum.this.methodHere();
		}

		public void methodHere() {

		}

		public static void demo() {

		}
	}

	private void testStaticConstructorAndInitializers() {
		Map<String, Integer> map = new HashMap<>() {
			{
				put("String", 10);
			}
		};

		new Baby() {
			{
				System.out.println("Hello!");
			}
		};
		new Baby();
		new Baby();
		new Baby();

	}

	public static class Baby {

		Baby() {
			System.out.println("Neeeeeeeeeeeeee");
		}

		{
			System.out.println("Empty {}");
		}

		static {
			System.out.println("static call");
		}
	}

	private void testLambda() {
		//convertNicePerson(new Nice() = anonymous class);
		//convertNicePerson(intensity -> System.out.println("Smiling with " + intensity + " intensity"));

		convertNicePerson(t -> System.out.println(t));

		convertNicePerson2(Integer::parseInt);

		List<String> messages = Arrays.asList("grass", "ass", "asshole", "beer");
		List<String> clearedMessages = messages.stream().filter(message -> message.contains("ass")).collect(Collectors.toList());

		System.out.println(clearedMessages);

		/*join(new Consumer<String>() {
		
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});*/

		join(System.out::println);
	}

	static void convertNicePerson(Consumer<String> consumer) {
		consumer.accept("Hello");
	}

	static void convertNicePerson2(Function<String, Integer> function) {
		function.apply("100");
	}

	static void convertNicePerson3(Supplier<String> function) {
		function.get();
	}

	/**
	 *
	 * @param consumer
	 * @deprecated do not use because it's bugged and will crash and boom your computer lol
	 */
	@Deprecated
	static void join(Consumer<String> consumer) {
		consumer.accept("Hello from method reference!");
	}

	private void testReflection() {
		try {
			Person person = new Person("Wiktor", 20);

			// Get a field
			//person.age;
			Field field = Person.class.getDeclaredField("age");

			field.setAccessible(true);
			int age = (int) field.get(person);

			System.out.println("Age is " + age);

			// Get a static field
			//Static has no instance so...
			Field staticField = Person.class.getDeclaredField("ageStatic");

			staticField.setAccessible(true);
			int ageStatic = (int) staticField.get(null);

			System.out.println("Age is " + ageStatic);

			// Get a method (with or without arguments)
			Method method = Person.class.getDeclaredMethod("privateMethod", String.class, int.class);
			method.setAccessible(true);

			String object = (String) method.invoke(person /*null for static*/, "Hello banana!", 1337);
			System.out.println(object);

			if (Modifier.isFinal(method.getModifiers()) && Modifier.isProtected(method.getModifiers()))
				System.out.println("Method privateMethod is protected and final!");

			// Get a constructor
			Constructor constructor = Person.class.getDeclaredConstructor();
			constructor.setAccessible(true);

			Person newPerson = (Person) constructor.newInstance();

			System.out.println(newPerson);

			// Get a class without importing it
			// Class.forName("net.minecraft.server.WEIRD_NUMBER.Achievement");

		} catch (ReflectiveOperationException ex) {
			ex.printStackTrace();
		}
	}

	private void testThreads() {
		System.out.println("Main thread number is: " + Thread.currentThread().getId());

		for (int i = 1; i <= 5; i++) {
			Counter counter = new Counter();

			counter.start(); // if implements Runnable then: new Thread(counter).start();
		}

		System.out.println("Program finished.");

		connectToDataBase(integer -> System.out.println("Here's the number " + integer));
	}

	// How to process results from the Internet, databases, web servers.
	// Because you can't easily do a return statement here.
	private static void connectToDataBase(Consumer<Integer> consumer) {
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int randomNumber = 10;

				consumer.accept(randomNumber);
			}
		}.start();
	}

	private static class Counter extends Thread /*or implements Runnable*/ {

		static int threadCount = 10;

		private final int id;

		Counter() {
			this.id = ++threadCount;
		}

		@Override
		public void run() {

			if (this.id != 13)
				throw new RuntimeException("Thread " + this.id + " is broken"); // even then the one (thread id=13) will be executed to the end

			for (int i = 1; i <= 5; i++) {
				System.out.println("[id=" + /*Thread.currentThread().getId()*/ this.id + "] Number is: " + i);

				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void testSynchronized() {
		new Accessor().start();
		new Accessor().start();
		new Accessor().start();
	}

	static void printMe() {
		System.out.println("DecreaseMe is: " + decreaseMe);
	}

	private static class Accessor extends Thread {
		@Override
		public void run() {

			/* for not static classes/methods use:
			synchronized (this) {

			}*/

			synchronized (LOCK) {
				while (decreaseMe-- > 0) {
					printMe();
				}
			}
		}
	}

	private void testTimer() {
		Timer timer = new Timer(); // Timer doesn't create a new thread!

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Timer task run");
			}

		}, 1000);

		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Timer is running!");

				this.cancel();
			}
		}, 2000 /*wait 2sec*/, 100 /*run every 0,1sec like a psychopath*/);

	}

	private void testLombok() {
		Person person = new Person(20);
		System.out.println(person);

		demo(null);

	}

	static void demo(@NonNull String message) {
		System.out.println(message);
	}

	public static void resursivePrint(int number) {
		if (number > 0) {
			System.out.println(number);

			number--;
			resursivePrint(number);
		}
	}
}
