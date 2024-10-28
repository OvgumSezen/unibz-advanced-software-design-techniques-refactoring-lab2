package org.asdt.movie.solid;

import org.asdt.movie.Movie;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    protected void initializePrice() {
        setPrice(2);
    }

    @Override
    public double getRentalBonusPrice(int daysRented) {
        if(daysRented <= 2) {
            return 0;
        }
        return (daysRented - 2) * 1.5;
    }

    @Override
    public int getFrequentRenterBonusPoints(int daysRented) {
        return 0;
    }
}
