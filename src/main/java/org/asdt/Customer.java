package org.asdt;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private final String name;
	private final List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		if(" ".equals(name)) {
			throw new IllegalArgumentException("variable \"name\" cannot be empty.");
		}
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

		for (Rental rental: rentals) {
            frequentRenterPoints += getFrequentRenterPoints(rental);
			result.append("\t")
					.append(rental.getMovie().getTitle())
					.append("\t").
					append(calculateRentalAmount(rental))
					.append("\n");
		}

		result.append("Amount owed is ")
				.append(calculateTotalRentalAmount())
				.append("\n")
				.append("You earned ")
				.append(frequentRenterPoints)
				.append(" frequent renter points");
		return result.toString();
	}

	private double calculateTotalRentalAmount() {
		double totalRentalAmount = 0;

		for(Rental rental: rentals) {
			totalRentalAmount += calculateRentalAmount(rental);
		}

		return totalRentalAmount;
	}

	private double calculateRentalAmount(Rental rental) {
		return rental.getAmount();
    }

	private int getFrequentRenterPoints(Rental rental) {
		return rental.getFrequentRenterPoints();
	}

	public String getName() {
		return name;
	}
}