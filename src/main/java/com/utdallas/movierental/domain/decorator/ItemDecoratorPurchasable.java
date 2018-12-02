package com.utdallas.movierental.domain.decorator;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.PurchasableItem;
import com.utdallas.movierental.domain.RentableItem;

public class ItemDecoratorPurchasable extends ItemDecorator implements PurchasableItem {

    public ItemDecoratorPurchasable(Item item) {
        super(item);
    }
}
