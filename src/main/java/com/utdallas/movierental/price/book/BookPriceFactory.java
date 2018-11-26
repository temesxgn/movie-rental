package com.utdallas.movierental.price.book;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

public final class BookPriceFactory extends PriceFactory {

  private CategoryType type;

  public BookPriceFactory(CategoryType categoryType) {
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
