package com.utdallas.movierental.checkoutoption.purchase;

import com.utdallas.movierental.checkoutoption.BaseCheckoutOption;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.frequentcustomerpoints.purchase.FrequentCustomerPointsPurchaseStrategyFactory;

import java.math.BigDecimal;

public class RegularPurchase extends BaseCheckoutOption implements Purchase {

    public RegularPurchase(final String customerId, final Item item) {
        super(customerId, item, CheckoutOptionType.PURCHASE);
        this.frequentRentalPointsStrategy = FrequentCustomerPointsPurchaseStrategyFactory.getStrategy(item.getCategoryType());
    }

    @Override
    public BigDecimal getChargeAmount() {
        return this.item.getPrice();
    }

    @Override
    public int getFrequentCustomerPoints() {
        return this.frequentRentalPointsStrategy.getPoints();
    }
}
