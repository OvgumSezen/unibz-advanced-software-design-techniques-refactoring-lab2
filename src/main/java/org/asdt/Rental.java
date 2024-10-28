package org.asdt;

import org.asdt.movie.Movie;

public class Rental {
	private final Movie movie;
	private final int daysRented;
	private double amount;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
		initializeAmount();
	}

	private void initializeAmount() {
		amount = movie.getPrice() + movie.getRentalBonusPrice(daysRented);
	}

	public int getFrequentRenterPoints() {
		return 1 + movie.getFrequentRenterBonusPoints(daysRented);
	}

	public double getAmount() {
		return amount;
	}

	public Movie getMovie() {
		return movie;
	}
}