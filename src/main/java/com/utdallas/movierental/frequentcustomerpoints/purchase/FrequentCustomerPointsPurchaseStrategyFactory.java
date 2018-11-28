package com.utdallas.movierental.frequentcustomerpoints.purchase;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.frequentcustomerpoints.FrequentCustomerPoints;

public class FrequentCustomerPointsPurchaseStrategyFactory {

    public static FrequentCustomerPoints getStrategy(CategoryType type) {
        FrequentCustomerPoints frequentCustomerPoints;

        switch(type) {
            case CHILDRENS:
                frequentCustomerPoints = new FrequentCustomerPointsPurchaseStrategyChildrensType();
                break;
            case NEW_RELEASE:
                frequentCustomerPoints = new FrequentCustomerPointsPurchaseStrategyNewReleaseType();
                break;
            case REGULAR:
            default:
                frequentCustomerPoints = new FrequentCustomerPointsPurchaseStrategyRegularType();
                break;
        }

        return frequentCustomerPoints;
    }
}
