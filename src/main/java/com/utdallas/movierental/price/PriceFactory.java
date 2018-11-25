package com.utdallas.movierental.price;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.price.purchase.PurchasePriceFactory;
import com.utdallas.movierental.price.rental.RentalPriceFactory;

public abstract class PriceFactory {

    public static PriceFactory getFactory(CheckoutOptionType optionType, CheckoutOption option) {
        switch (optionType) {
            case PURCHASE:
                return new PurchasePriceFactory(option);
            case RENT:
            default: //TODO maybe add default or throw exception
                return new RentalPriceFactory((RegularRental) option);

        }
    }

    public abstract Price getPrice();
}
