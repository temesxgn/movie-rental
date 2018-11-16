package com.utdallas.movierental.rental;

import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

public interface Rental {

    int getDaysRented();

    String getMovieTitle();

    MovieType getMovieType();

    double getChargeAmount();

    int getFrequentRenterPoints();
}
