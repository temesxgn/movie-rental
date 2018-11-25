package com.utdallas.movierental.frequentRenterPoints;

public abstract class FrequentRenterPointsStrategyFactory {

    public FrequentRenterPointsStrategyFactory() {

    }

    //TODO update this
    public static FrequentRenterPointsStrategyFactory getFactory(FrequentRenterPointsStrategyFactoryType type) {
        switch (type) {
            case CUSTOMER:
                //return new FrequentRenterPointsCustomerStrategyFactory();
            case PURCHASE:
                //return new FrequentRenterPointsPurchaseStrategyFactory();
            case RENTAL:
            default:
                //return new FrequentRenterPointsRentalStrategyFactory();
                return null;
        }
    }

    public abstract FrequentRenterPointsStrategy getStrategy();

}
