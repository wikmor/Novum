package me.wikmor.novum.person;

public abstract class LivingEntity {

	private String name;

	public LivingEntity(String name) {
		this.name = name;

		EntityRegister.increaseRegisteredEntities();
	}

	public abstract void walk();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LivingEntity{name=" + this.name + "}";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LivingEntity && ((LivingEntity) obj).getName().equals(this.name);
	}
}
