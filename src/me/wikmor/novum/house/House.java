package me.wikmor.novum.house;

public class House {

	private static int registeredHouses = 0;

	private final int size;

	public House(int size) {
		this.size = size;

		//registeredHouses++;
		System.out.println("New house registered! Total: " + ++registeredHouses);
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "House{size=" + this.size + "}";
	}

	public static int getRegisteredHouses() {
		return registeredHouses;
	}
}
