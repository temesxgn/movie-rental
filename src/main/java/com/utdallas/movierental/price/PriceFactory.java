package com.utdallas.movierental.price;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;
import com.utdallas.movierental.price.book.BookPriceFactory;
import com.utdallas.movierental.price.cd.CDPriceFactory;
import com.utdallas.movierental.price.dvd.DVDPriceFactory;
import com.utdallas.movierental.price.game.GamePriceFactory;
import com.utdallas.movierental.price.movie.MoviePriceFactory;

public abstract class PriceFactory {

    public static PriceFactory getItemPriceFactory(CategoryType categoryType, ModelType modelType) {
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
