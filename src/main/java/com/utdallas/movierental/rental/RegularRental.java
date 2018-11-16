package com.utdallas.movierental.rental;


import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.price.PriceFactory;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.price.Price;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RegularRental implements Rental {

    private Movie movie;
    private Price price;
    private int daysRented;
    private FrequentRenterPoints frequentRentalPointsStrategy;

    public RegularRental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.price = PriceFactory.getPrice(movie.getMovieType());
        this.frequentRentalPointsStrategy = FrequentRenterPointsStrategyFactory.newRentalFrequentRenterPointsStrategy(movie.getMovieType(), daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public MovieType getMovieType() {
        return movie.getMovieType();
    }

    public double getChargeAmount() {
        return price.getChargeAmount(daysRented);
    }

    public int getFrequentRenterPoints() {
        return frequentRentalPointsStrategy.getPoints();
    }

}