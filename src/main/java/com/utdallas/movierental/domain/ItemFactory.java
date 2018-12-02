package com.utdallas.movierental.domain;

import com.utdallas.movierental.domain.decorator.ItemDecoratorClearance;
import com.utdallas.movierental.domain.decorator.ItemDecoratorPurchasable;
import com.utdallas.movierental.domain.decorator.ItemDecoratorRentable;
import com.utdallas.movierental.domain.model.*;
import com.utdallas.movierental.domain.type.CategoryType;

public final class ItemFactory {

    public static Book createBook(final String title, final CategoryType type, double basePrice) {
        return new Book(title, type, basePrice);
    }

    public static CD createCD(final String title, final CategoryType type, double basePrice) {
        return new CD(title, type, basePrice);
    }

    public static DVD createDVD(final String title, final CategoryType type, double basePrice) {
        return new DVD(title, type, basePrice);
    }

    public static Game createGame(final String title, final CategoryType type, double basePrice) {
        return new Game(title, type, basePrice);
    }

    public static Movie createMovie(final String title, final CategoryType type, double basePrice) {
        return new Movie(title, type, basePrice);
    }

    public static Item createClearanceItem(Item item) {
        return new ItemDecoratorClearance(item);
    }

    public static Item createPurchasableItem(Item item) {
        return new ItemDecoratorPurchasable(item);
    }

    public static Item createRentableItem(Item item) {
        return new ItemDecoratorRentable(item);
    }
}
