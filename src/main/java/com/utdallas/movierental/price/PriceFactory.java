package com.utdallas.movierental.price;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.checkoutoption.CheckoutOptionType;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.ModelType;
import com.utdallas.movierental.price.book.BookPriceFactory;
import com.utdallas.movierental.price.cd.CDPriceFactory;
import com.utdallas.movierental.price.dvd.DVDPriceFactory;
import com.utdallas.movierental.price.game.GamePriceFactory;
import com.utdallas.movierental.price.movie.MoviePriceFactory;
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

    public static PriceFactory getFactory(CategoryType categoryType, ModelType modelType) {
        switch (modelType) {
            case BOOK:
                return new BookPriceFactory(categoryType);
            case CD:
                return new CDPriceFactory(categoryType);
            case DVD:
                return new DVDPriceFactory(categoryType);
            case GAME:
                return new GamePriceFactory(categoryType);
            case MOVIE:
                return new MoviePriceFactory(categoryType);
            default: //TODO maybe add default or throw exception
                return new GamePriceFactory(categoryType);

        }
    }

    public abstract Price getPrice();
}
