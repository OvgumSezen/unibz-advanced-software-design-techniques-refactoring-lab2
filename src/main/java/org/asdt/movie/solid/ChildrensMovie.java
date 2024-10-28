package org.asdt.movie.solid;

import org.asdt.movie.Movie;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    protected void initializePrice() {
        setPrice(1.5);
    }

    @Override
    public double getRentalBonusPrice(int daysRented) {
        if(daysRented <= 3) {
            return 0;
        }

        return (daysRented - 3) * 1.5;
    }

    @Override
    public int getFrequentRenterBonusPoints(int daysRented) {
        return 0;
    }
}
