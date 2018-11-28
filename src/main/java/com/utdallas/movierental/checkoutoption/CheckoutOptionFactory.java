package com.utdallas.movierental.checkoutoption;

import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.checkoutoption.purchase.RegularPurchase;
import com.utdallas.movierental.checkoutoption.rental.ExtendedRental;
import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.Item;

public final class CheckoutOptionFactory {

    private static final int EXTENDED_RENTAL_MIN_DAYS = 4;

    public static Purchase createPurchaseItem(final Customer customer, final Item kingdomHearts) {
        return new RegularPurchase(customer.getCustomerId(), kingdomHearts);
    }

    public static Rental createRentalItem(final Customer customer, final Item item, final int daysRented) {
        return daysRented < EXTENDED_RENTAL_MIN_DAYS ? new RegularRental(customer.getCustomerId(), item, daysRented)
                : new ExtendedRental(customer.getCustomerId(), item, daysRented);
    }
}
