package com.utdallas.movierental.checkoutoption;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

import java.math.BigDecimal;

//TODO Figure out a better name
public abstract class BaseCheckoutOption implements CheckoutOption {

    private String customerId;
    private Item item;
    protected Price price;
    protected FrequentRenterPoints frequentRentalPointsStrategy;

    public BaseCheckoutOption(String customerId, Item item, CheckoutOptionType type) {
        this.customerId = customerId;
        this.item = item;
        this.price = PriceFactory.getFactory(type, this).getPrice();
    }

    @Override
    public String getTitle() {
        return item.getTitle();
    }

    @Override
    public CategoryType getCategory() {
        return item.getCategoryType();
    }

    @Override
    public BigDecimal getChargeAmount() {
        return price.getChargeAmount();
    }

    @Override
    public int getFrequentRenterPoints() {
        return frequentRentalPointsStrategy.getPoints();
    }

}
