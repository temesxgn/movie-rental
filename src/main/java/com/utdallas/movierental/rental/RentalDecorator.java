package com.utdallas.movierental.rental;

import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;

public abstract class RentalDecorator implements Rental  {

    protected Rental rental;

    public RentalDecorator(Rental rental) {
        this.rental = rental;
    }

    @Override
    public int getDaysRented() {
        return this.rental.getDaysRented();
    }

    @Override
    public String getMovieTitle() {
        return this.rental.getMovieTitle();
    }

    @Override
    public MovieType getMovieType() {
        return this.rental.getMovieType();
    }

    @Override
    public double getChargeAmount() {
        return this.rental.getChargeAmount();
    }

    @Override
    public int getFrequentRenterPoints() {
        return this.rental.getFrequentRenterPoints();
    }
}
