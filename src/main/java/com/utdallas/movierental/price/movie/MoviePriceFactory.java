package com.utdallas.movierental.price.movie;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

public final class MoviePriceFactory extends PriceFactory {

  private CategoryType type;

  public MoviePriceFactory(CategoryType categoryType) {
    this.type = categoryType;
  }

  public Price getPrice() {
    return getPrice(type);
  }

  private static Price getPrice(final CategoryType type) {
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