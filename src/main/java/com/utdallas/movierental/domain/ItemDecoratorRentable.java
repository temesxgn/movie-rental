package com.utdallas.movierental.domain;

public class ItemDecoratorRentable extends ItemDecorator implements Item {

    public ItemDecoratorRentable(Item item) {
        super(item);
    }
}
