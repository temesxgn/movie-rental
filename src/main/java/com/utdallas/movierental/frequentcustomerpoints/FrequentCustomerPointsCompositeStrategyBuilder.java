package com.utdallas.movierental.frequentcustomerpoints;

import com.utdallas.movierental.frequentcustomerpoints.customer.FrequentCustomerPointsRentalStrategyCustomerAgeRangeAndRentNewRelease;
import com.utdallas.movierental.frequentcustomerpoints.customer.FrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes;

public class FrequentCustomerPointsCompositeStrategyBuilder {

    private FrequentCustomerPointsCompositeStrategy strategy;

    public FrequentCustomerPointsCompositeStrategyBuilder() {
        strategy = new FrequentCustomerPointsCompositeStrategy();
    }

    public void withFrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes() {
        strategy.addStrategy(new FrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes());
    }

    public void withFrequentCustomerPointsRentalStrategyCustomerAgeRangeAndRentNewRelease() {
        strategy.addStrategy(new FrequentCustomerPointsRentalStrategyCustomerAgeRangeAndRentNewRelease());
    }

    public FrequentCustomerPointsStrategy getStrategy() {
        return strategy;
    }

}
