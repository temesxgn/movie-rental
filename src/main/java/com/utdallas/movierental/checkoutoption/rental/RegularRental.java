package com.utdallas.movierental.checkoutoption.rental;


import com.utdallas.movierental.checkoutoption.BaseCheckoutOption;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentRenterPoints.rental.FrequentRenterPointsRentalStrategyFactory;

public class RegularRental extends BaseCheckoutOption implements Rental {

    private int daysRented;

    public RegularRental(final String customerId, final Item item, final int daysRented) {
        super(customerId, item, CheckoutOptionType.RENT);
        this.daysRented = daysRented;
        this.frequentRentalPointsStrategy = FrequentRenterPointsRentalStrategyFactory.getStrategy(item.getCategoryType(), daysRented);
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }
}