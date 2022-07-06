package me.wikmor.novum;

public enum CalculatorMode {

	LEFT_HAND_NUMBER(0),
	RIGHT_HAND_NUMBER(1),
	OPERATOR(2);

	private final int number;

	CalculatorMode(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}
}
