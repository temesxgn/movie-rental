package com.utdallas.movierental.checkoutoption.rental;


import com.utdallas.movierental.checkoutoption.BaseCheckoutOption;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentRenterPoints.rental.FrequentRenterPointsRentalStrategyFactory;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class RegularRental extends BaseCheckoutOption implements Rental {

    private int daysRented;
    protected static final BigDecimal PERCENTAGE = BigDecimal.valueOf(85);

    public RegularRental(final String customerId, final Item item, final int daysRented) {
        super(customerId, item, CheckoutOptionType.RENT);
        this.daysRented = daysRented;
        this.frequentRentalPointsStrategy = FrequentRenterPointsRentalStrategyFactory.getStrategy(item.getCategoryType(), daysRented);
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public BigDecimal getChargeAmount() {
        return NumberUtils.getPercentage(this.item.getPrice(), PERCENTAGE);
    }

    @Override
    //TODO figure out proper way to get points
    public int getFrequentRenterPoints() {
        return this.frequentRentalPointsStrategy.getPoints();
    }
}