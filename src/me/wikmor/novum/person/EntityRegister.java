package me.wikmor.novum.person;

public class EntityRegister {

	private static int registeredEntities = 0;

	public static void increaseRegisteredEntities() {
		registeredEntities++;
	}

	public static int getRegisteredEntities() {
		return registeredEntities;
	}

}
