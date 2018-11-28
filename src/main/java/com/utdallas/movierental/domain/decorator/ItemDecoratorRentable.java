package com.utdallas.movierental.domain.decorator;

import com.utdallas.movierental.domain.Item;

public class ItemDecoratorRentable extends ItemDecorator implements Item {

    public ItemDecoratorRentable(Item item) {
        super(item);
    }
}
