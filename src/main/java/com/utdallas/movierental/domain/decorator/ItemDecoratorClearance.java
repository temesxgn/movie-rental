package com.utdallas.movierental.domain.decorator;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.PurchasableItem;

import java.math.BigDecimal;

public class ItemDecoratorClearance extends ItemDecoratorPurchasable {

    private static final BigDecimal price = BigDecimal.valueOf(2.99);

    public ItemDecoratorClearance(Item item) {
        super(item);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
