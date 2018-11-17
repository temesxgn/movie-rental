package com.utdallas.movierental.rental;

import com.utdallas.movierental.domain.CategoryType;

import java.math.BigDecimal;

public interface Rental {

    int getDaysRented();

    String getMovieTitle();

    CategoryType getMovieType();

    BigDecimal getChargeAmount();

    int getFrequentRenterPoints();
}
