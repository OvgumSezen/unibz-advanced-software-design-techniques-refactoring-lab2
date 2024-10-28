package org.asdt.movie;

public abstract class Movie {
	private final String title;
	private double price;

	public Movie(String title) {
		this.title = title;
		initializePrice();
	}

	protected abstract void initializePrice();

	public abstract double getRentalBonusPrice(int daysRented);

	public abstract int getFrequentRenterBonusPoints(int daysRented);

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
}