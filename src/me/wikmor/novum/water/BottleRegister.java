package me.wikmor.novum.water;

import java.util.HashMap;
import java.util.Map;

public class BottleRegister {

	private static int registeredBottles = 0;

	private static Map<Integer, WaterBottle> waterBottles = new HashMap<>();

	public static void increaseRegisteredBottles(WaterBottle waterBottle) {
		registeredBottles++; // first increase the number of registered bottles, so the id in map starts from 1

		waterBottles.put(registeredBottles, waterBottle);
	}

	public static int getRegisteredBottles() {
		return registeredBottles;
	}

	/*public static String getBottlesInformation() {
		for (WaterBottle bottle : BottleRegister.getWaterBottles().values())
			System.out.println(bottle);
		return null;
	}*/

	public static WaterBottle getWaterBottleById(int id) {
		if (waterBottles.containsKey(id))
			return waterBottles.get(id);

		return null;
	}

	public static Map<Integer, WaterBottle> getWaterBottles() {
		return waterBottles;
	}
}
