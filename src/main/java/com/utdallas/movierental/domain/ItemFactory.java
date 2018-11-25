package com.utdallas.movierental.domain;

import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.checkoutoption.purchase.RegularPurchase;
import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.models.*;

public final class ItemFactory {

    public static Purchase createPurchaseItem(final Customer customer, final Item kingdomHearts) {
        return new RegularPurchase(customer.getCustomerId(), kingdomHearts);
    }

    public static Rental createRentalItem(final Customer customer, final Item item, final int daysRented) {
        return new RegularRental(customer.getCustomerId(), item, daysRented);
    }

    public static Book createBook(final String title, final CategoryType type) {
        return new Book(title, type);
    }

    public static CD createCD(final String title, final CategoryType type) {
        return new CD(title, type);
    }

    public static DVD createDVD(final String title, final CategoryType type) {
        return new DVD(title, type);
    }

    public static Game createGame(final String title, final CategoryType type) {
        return new Game(title, type);
    }

    public static Movie createMovie(final String title, final CategoryType type) {
        return new Movie(title, type);
    }
}
