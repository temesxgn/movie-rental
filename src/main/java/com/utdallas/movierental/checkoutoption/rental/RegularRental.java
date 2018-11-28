package com.utdallas.movierental.checkoutoption.rental;


import com.utdallas.movierental.checkoutoption.BaseCheckoutOption;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentcustomerpoints.rental.FrequentCustomerPointsRentalStrategyFactory;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class RegularRental extends BaseCheckoutOption implements Rental {

    private int daysRented;
    protected static BigDecimal PERCENTAGE = BigDecimal.valueOf(85);

    public RegularRental(final String customerId, final Item item, final int daysRented) {
        super(customerId, item, CheckoutOptionType.RENT);
        this.daysRented = daysRented;
        this.frequentRentalPointsStrategy = FrequentCustomerPointsRentalStrategyFactory.getStrategy(item.getCategoryType(), daysRented);
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    //TODO  should this be designed with Strategy or keep as decorator-ish?
    public BigDecimal getChargeAmount() {
        return NumberUtils.getPercentage(this.item.getPrice(), PERCENTAGE);
    }

    @Override
    //TODO figure out proper way to get points
    public int getFrequentCustomerPoints() {
        return this.frequentRentalPointsStrategy.getPoints();
    }
}