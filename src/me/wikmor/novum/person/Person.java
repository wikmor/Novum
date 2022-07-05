package me.wikmor.novum.person;

public class Person extends LivingEntity {

	//private static Person john = new Person("John", 5);
	public static final Person JOHN = new Person("John", 5); // constant

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

	@Override
	public String toString() {
		return "Person{name=" + this.getName() + ", age=" + this.age + "}";
	}

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
