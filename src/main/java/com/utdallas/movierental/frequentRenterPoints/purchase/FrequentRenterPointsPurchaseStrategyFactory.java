package com.utdallas.movierental.frequentRenterPoints.purchase;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;

public class FrequentRenterPointsPurchaseStrategyFactory {

    public static FrequentRenterPoints getStrategy(CategoryType type) {
        FrequentRenterPoints frequentRenterPoints;

        if (type.equals(CategoryType.CHILDRENS)) {
            frequentRenterPoints = new FrequentRenterPointsPurchaseStrategyChildrensType();
        } else if (type.equals(CategoryType.NEW_RELEASE)) {
            frequentRenterPoints = new FrequentRenterPointsPurchaseStrategyNewReleaseType();
        } else {
            frequentRenterPoints = new FrequentRenterPointsPurchaseStrategyRegularType();
        }

        return frequentRenterPoints;
    }
}
