package com.utdallas.movierental.price;

import com.utdallas.movierental.exception.IllegalMovieTypeException;
import com.utdallas.movierental.movie.MovieType;

public final class PriceFactory {

  private static final String ERROR_MSG = "Invalid Movie Type";

  private PriceFactory() {

  }

  public static Price getPrice(MovieType type) throws IllegalMovieTypeException {
    switch (type) {
      case CHILDRENS:
        return new ChildrensPrice();
      case NEW_RELEASE:
        return new NewReleasePrice();
      case REGULAR:
        return new RegularPrice();
      default:
        throw new IllegalMovieTypeException(ERROR_MSG);
    }
  }
}
