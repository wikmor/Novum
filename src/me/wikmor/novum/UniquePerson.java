package me.wikmor.novum;

import java.util.Objects;

public class UniquePerson {

	private final String uniqueId;

	public UniquePerson(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uniqueId);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof UniquePerson && ((UniquePerson) obj).getUniqueId().equals(this.uniqueId);
	}
}
