package com.utdallas.movierental.frequentcustomerpoints.customer;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.frequentcustomerpoints.*;

import java.util.List;
import java.util.stream.Collectors;

public class FrequentCustomerPointsCustomerStrategyFactory {

    private static final int AGE_MINIMUM = 18;
    private static final int AGE_MAXIMUM = 22;
    private static final int RENTAL_CATEGORY_TYPE_MINIMUM = 3;
    private static final int PURCHASE_CATEGORY_TYPE_MINIMUM = 2;

    public static FrequentCustomerPoints getStrategy(Customer customer, List<CheckoutOption> items) {
        FrequentCustomerPointsCompositeStrategy strategy = new FrequentCustomerPointsCompositeStrategy();

        //TODO is this the right way to get item type?
        List<CheckoutOption> rentals = items.stream().filter(Rental.class::isInstance).collect(Collectors.toList());
        List<CheckoutOption> purchases = items.stream().filter(Purchase.class::isInstance ).collect(Collectors.toList());

        strategy.addStrategy(getRentingPoints(customer, rentals));
        strategy.addStrategy(getPurchasingPoints(purchases));

        return strategy;
    }

    private static FrequentCustomerPointsStrategy getRentingPoints(Customer customer, List<CheckoutOption> rentals) {
        FrequentCustomerPointsCompositeStrategyBuilder builder = new FrequentCustomerPointsCompositeStrategyBuilder();

        boolean isCustomerRentingMoreThanTwoTypes = rentals.stream().map(CheckoutOption::getCategory).distinct().count() >= RENTAL_CATEGORY_TYPE_MINIMUM;
        boolean isWithinAgeRange = customer.getAge() >= AGE_MINIMUM && customer.getAge() <= AGE_MAXIMUM;
        boolean isRentingAtLeastOneNewRelease = rentals.stream().anyMatch(rental -> rental.getCategory().equals(CategoryType.NEW_RELEASE));

        if (isCustomerRentingMoreThanTwoTypes) {
            builder.withFrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes();
        }

        if (isWithinAgeRange && isRentingAtLeastOneNewRelease) {
            builder.withFrequentCustomerPointsRentalStrategyCustomerAgeRangeAndRentNewRelease();
        }

        return builder.getStrategy();
    }

    private static FrequentCustomerPointsStrategy getPurchasingPoints(List<CheckoutOption> purchases) {
        FrequentCustomerPointsCompositeStrategyBuilder builder = new FrequentCustomerPointsCompositeStrategyBuilder();

        boolean isCustomerPurchasingMoreThanTwoTypes = purchases.stream().map(CheckoutOption::getCategory).distinct().count() >= PURCHASE_CATEGORY_TYPE_MINIMUM;

        if (isCustomerPurchasingMoreThanTwoTypes) {
            builder.withFrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes();
        }

        return builder.getStrategy();
    }
}
