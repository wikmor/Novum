package me.wikmor.novum;

public enum Position {

	CEO(500) {
		@Override
		public void giveToPlayer(String player) {
			System.out.println("I have a boat");
		}
	},
	COO(250),
	CTO(100),
	ZOMBIE(-100),
	DOUCHE(1981279278);

	private final int annualSalaryThousands;

	Position(int salary) {
		this.annualSalaryThousands = salary;
	}

	public int getAnnualSalaryThousands() {
		return this.annualSalaryThousands;
	}

	public void giveToPlayer(String player) {
		System.out.println("I have a bike");
		// default behavior here
	}
}
