package org.asdt.movie.solid;

import org.asdt.movie.Movie;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    protected void initializePrice() {
        setPrice(0);
    }

    @Override
    public double getRentalBonusPrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterBonusPoints(int daysRented) {
        if(daysRented > 1) {
            return 1;
        }
        return 0;
    }
}
