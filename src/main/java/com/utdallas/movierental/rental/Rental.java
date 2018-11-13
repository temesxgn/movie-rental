package com.utdallas.movierental.rental;


import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.price.PriceFactory;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.price.Price;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Rental implements PropertyChangeListener {
    private Movie movie;
    private Price price;
    private int quantity;
    private int daysRented;
    private FrequentRenterPoints frequentRentalPointsStrategy;

    public Rental(Movie movie, int quantity, int daysRented) {
        this.movie = movie;
        this.movie.addPropertyChangeListener(this); //TODO maybe move this to main method?
        this.daysRented = daysRented;
        this.quantity = quantity;
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
        return price.getChargeAmount(daysRented) * quantity;
    }

    public int getFrequentRenterPoints() {
        return frequentRentalPointsStrategy.getPoints() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MovieType type = (MovieType)evt.getNewValue();
        price = PriceFactory.getPrice(type);
        frequentRentalPointsStrategy = FrequentRenterPointsStrategyFactory.newRentalFrequentRenterPointsStrategy(type, daysRented);
    }
}