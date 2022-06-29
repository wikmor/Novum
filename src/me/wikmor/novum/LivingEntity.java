package me.wikmor.novum;

public abstract class LivingEntity {

	String name;

	LivingEntity(String name) {
		this.name = name;
	}

	abstract void walk();

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
}
