package me.wikmor.novum.water;

public class BottleRegister {

	private static int registeredBottles = 0;

	public static void increaseRegisteredBottles() {
		registeredBottles++;
	}

	public static int getRegisteredBottles() {
		return registeredBottles;
	}
}
