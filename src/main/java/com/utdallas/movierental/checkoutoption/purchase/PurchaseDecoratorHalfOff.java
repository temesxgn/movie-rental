package com.utdallas.movierental.checkoutoption.purchase;

import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class PurchaseDecoratorHalfOff extends PurchaseDecorator {

    private static final BigDecimal PERCENTAGE = BigDecimal.valueOf(50);

    public PurchaseDecoratorHalfOff(Purchase purchase) {
        super(purchase);
    }

    @Override
    public BigDecimal getChargeAmount() {
        return NumberUtils.getPercentage(purchase.getChargeAmount(), PERCENTAGE);
    }

    @Override
    public int getFrequentCustomerPoints() {
        return BigDecimal.ZERO.intValue();
    }

    @Override
    public String toString() {
        return "Half Off";
    }

}
