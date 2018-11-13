package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategy;

import java.util.ArrayList;
import java.util.List;

public class FrequentRenterPointsCustomerStrategy extends FrequentRenterPointsStrategy {

    private List<FrequentRenterPointsStrategy> frequentRenterPointsStrategyList;

    public FrequentRenterPointsCustomerStrategy() {
        frequentRenterPointsStrategyList = new ArrayList<>();
    }

    public void addStrategy(FrequentRenterPointsStrategy strategy) {
        frequentRenterPointsStrategyList.add(strategy);
    }

    @Override
    public int getPoints() {
        return frequentRenterPointsStrategyList.stream().mapToInt(FrequentRenterPointsStrategy::getPoints).sum();
    }
}
