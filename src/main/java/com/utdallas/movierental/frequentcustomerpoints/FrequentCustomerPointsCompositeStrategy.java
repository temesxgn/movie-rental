package com.utdallas.movierental.frequentcustomerpoints;

import java.util.ArrayList;
import java.util.List;

public class FrequentCustomerPointsCompositeStrategy extends FrequentCustomerPointsStrategy {

    private List<FrequentCustomerPointsStrategy> frequentCustomerPointsStrategyList;

    public FrequentCustomerPointsCompositeStrategy() {
        frequentCustomerPointsStrategyList = new ArrayList<>();
    }

    public void addStrategy(FrequentCustomerPointsStrategy strategy) {
        frequentCustomerPointsStrategyList.add(strategy);
    }

    @Override
    public int getPoints() {
        return frequentCustomerPointsStrategyList.stream().mapToInt(FrequentCustomerPointsStrategy::getPoints).sum();
    }
}
