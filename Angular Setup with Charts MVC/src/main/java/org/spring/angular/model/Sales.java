package org.spring.angular.model;

public class Sales {

	@Override
	public String toString() {
		return "{amount:" + amount + "}";
	}

	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
