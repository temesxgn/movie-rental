package com.utdallas.movierental.frequentRenterPoints.customer;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.frequentRenterPoints.*;
import com.utdallas.movierental.frequentRenterPoints.rental.FrequentRenterPointsRentalStrategyCustomerAgeRangeAndRentNewRelease;
import com.utdallas.movierental.frequentRenterPoints.rental.FrequentRenterPointsRentalStrategyCustomerRentMoreThanTwoTypes;

import java.util.List;
import java.util.stream.Collectors;

public class FrequentRenterPointsCustomerStrategyFactory {

    private static final int AGE_MINIMUM = 18;
    private static final int AGE_MAXIMUM = 22;
    private static final int CATEGORY_TYPE_MINIMUM = 3;

    public static FrequentRenterPoints getStrategy(Customer customer, List<CheckoutOption> items) {
        FrequentRenterPointsCompositeStrategy strategy = new FrequentRenterPointsCompositeStrategy();

        List<CheckoutOption> rentals = items.stream().filter(item -> item instanceof Rental).collect(Collectors.toList());
        List<CheckoutOption> purchases = items.stream().filter(item -> item instanceof Purchase).collect(Collectors.toList());

        strategy.addStrategy(getRentingPoints(customer, rentals));
        strategy.addStrategy(getPurchasingPoints(customer, purchases));

        return strategy;
    }

    private static FrequentRenterPointsStrategy getRentingPoints(Customer customer, List<CheckoutOption> rentals) {
        FrequentRenterPointsCompositeStrategy strategy = new FrequentRenterPointsCompositeStrategy();

        boolean isCustomerRentingMoreThanTwoTypes = rentals.stream().map(CheckoutOption::getCategory).distinct().count() >= CATEGORY_TYPE_MINIMUM;
        boolean isWithinAgeRange = customer.getAge() >= AGE_MINIMUM && customer.getAge() <= AGE_MAXIMUM;
        boolean isRentingAtLeastOneNewRelease = rentals.stream().anyMatch(rental -> rental.getCategory().equals(CategoryType.NEW_RELEASE));

        if (isCustomerRentingMoreThanTwoTypes) {
            strategy.addStrategy(new FrequentRenterPointsRentalStrategyCustomerRentMoreThanTwoTypes());
        }

        if (isWithinAgeRange && isRentingAtLeastOneNewRelease) {
            strategy.addStrategy(new FrequentRenterPointsRentalStrategyCustomerAgeRangeAndRentNewRelease());
        }

        return strategy;
    }

    private static FrequentRenterPointsStrategy getPurchasingPoints(Customer customer, List<CheckoutOption> purchases) {
        FrequentRenterPointsCompositeStrategy strategy = new FrequentRenterPointsCompositeStrategy();

        return strategy;
    }
}
