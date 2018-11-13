package com.utdallas.movierental.price;

import com.utdallas.movierental.exception.IllegalMovieTypeException;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.price.ChildrensPrice;
import com.utdallas.movierental.price.NewReleasePrice;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.RegularPrice;

public final class PriceFactory {

  private PriceFactory() {

  }

  public static Price getPrice(MovieType type) {
    switch (type) {
      case CHILDRENS:
        return new ChildrensPrice();
      case NEW_RELEASE:
        return new NewReleasePrice();
      case REGULAR:
      default:
        return new RegularPrice();
    }
  }
}
