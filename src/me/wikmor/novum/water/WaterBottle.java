package me.wikmor.novum.water;

public class WaterBottle {

	private String name;
	private double capacity;
	private boolean isSparkling;
	// TODO private long dateOfManufacture;
	// TODO private long expiryDate;

	public WaterBottle() {
		this("Polaris Muszyński");
	}

	public WaterBottle(String name) {
		this(name, 1.5);
	}

	public WaterBottle(String name, double capacity) {
		this(name, capacity, false);
	}

	public WaterBottle(String name, double capacity, boolean isSparkling) {
		this.name = name;
		this.capacity = capacity;
		this.isSparkling = isSparkling;

		BottleRegister.increaseRegisteredBottles();
	}

	public String getName() {
		return name;
	}

	public double getCapacity() {
		return capacity;
	}

	public boolean isSparkling() {
		return isSparkling;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public void setSparkling(boolean isSparkling) {
		this.isSparkling = isSparkling;
	}
}
