package com.utdallas.movierental.domain.decorator;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.RentableItem;

public class ItemDecoratorRentable extends ItemDecorator implements RentableItem {

    public ItemDecoratorRentable(Item item) {
        super(item);
    }
}
