package com.utdallas.movierental.rental;


import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.RentalItem;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

import java.math.BigDecimal;

public class RegularRental implements Rental {

    private String customerId;
    private RentalItem item;
    private Price price;
    private int daysRented;
    private FrequentRenterPoints frequentRentalPointsStrategy;

    public RegularRental(final String customerId, final RentalItem item, final int daysRented) {
        this.customerId = customerId;
        this.item = item;
        this.daysRented = daysRented;
        this.price = PriceFactory.getPrice(item.getCategoryType());
        this.frequentRentalPointsStrategy = FrequentRenterPointsStrategyFactory.newRentalFrequentRenterPointsStrategy(item.getCategoryType(), daysRented);
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public String getMovieTitle() {
        return item.getTitle();
    }

    public CategoryType getMovieType() {
        return item.getCategoryType();
    }

    public BigDecimal getChargeAmount() {
        return price.getChargeAmount(daysRented);
    }

    public int getFrequentRenterPoints() {
        return frequentRentalPointsStrategy.getPoints();
    }

}