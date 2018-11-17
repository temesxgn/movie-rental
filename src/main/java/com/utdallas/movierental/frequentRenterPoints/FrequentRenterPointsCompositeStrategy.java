package com.utdallas.movierental.frequentRenterPoints;

import java.util.ArrayList;
import java.util.List;

public class FrequentRenterPointsCompositeStrategy extends FrequentRenterPointsStrategy {

    private List<FrequentRenterPointsStrategy> frequentRenterPointsStrategyList;

    public FrequentRenterPointsCompositeStrategy() {
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
