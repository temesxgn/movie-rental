package com.utdallas.movierental;


import com.utdallas.movierental.exception.IllegalMovieTypeException;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.price.PriceFactory;
import com.utdallas.movierental.price.Price;

public class Rental {
    private Movie movie;
    private Price price;
    private int daysRented;

    public Rental(Movie movie, int daysRented) throws IllegalMovieTypeException {
        this.movie = movie;
        this.daysRented = daysRented;
        this.price = PriceFactory.getPrice(movie.getMovieType());
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
        return price.getChargeAmount(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return price.getFrequentRenterPoints(getDaysRented());
    }

}