package com.utdallas.movierental.checkoutoption;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentcustomerpoints.FrequentCustomerPoints;

//TODO Figure out a better name
public abstract class BaseCheckoutOption implements CheckoutOption {

    protected String customerId;
    protected Item item;
    protected FrequentCustomerPoints frequentRentalPointsStrategy;

    public BaseCheckoutOption(String customerId, Item item) {
        this.customerId = customerId;
        this.item = item;
    }

    @Override
    public String getTitle() {
        return item.getTitle();
    }

    @Override
    public CategoryType getCategory() {
        return item.getCategoryType();
    }

}
