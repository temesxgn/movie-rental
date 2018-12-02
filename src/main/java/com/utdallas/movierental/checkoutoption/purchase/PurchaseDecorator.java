package com.utdallas.movierental.checkoutoption.purchase;

import com.utdallas.movierental.domain.type.CategoryType;

import java.math.BigDecimal;

public abstract class PurchaseDecorator implements Purchase  {

    protected Purchase purchase;

    public PurchaseDecorator(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String getTitle() {
        return this.purchase.getTitle();
    }

    @Override
    public CategoryType getCategory() {
        return this.purchase.getCategory();
    }

    @Override
    public BigDecimal getChargeAmount() {
        return this.purchase.getChargeAmount();
    }

    @Override
    public int getFrequentCustomerPoints() {
        return this.purchase.getFrequentCustomerPoints();
    }
}
